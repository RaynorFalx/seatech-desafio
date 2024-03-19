package com.seatech.clientapi.service;

import com.seatech.clientapi.entity.Cliente;
import com.seatech.clientapi.entity.Endereco;
import com.seatech.clientapi.entity.dto.request.ClientRequestDTO;
import com.seatech.clientapi.entity.dto.response.CEPIntegrationResponseDTO;
import com.seatech.clientapi.entity.dto.response.ClientResponseDTO;
import com.seatech.clientapi.exception.NegocialException;
import com.seatech.clientapi.integration.ViaCepIntegrationClient;
import com.seatech.clientapi.repository.ClientRepository;
import com.seatech.clientapi.util.mapstruct.ClientMapper;
import com.seatech.clientapi.util.mapstruct.EmailMapper;
import com.seatech.clientapi.util.mapstruct.TelefoneMapper;
import feign.FeignException;
import org.springframework.stereotype.Service;

import static org.springframework.http.HttpStatus.BAD_REQUEST;


@Service
public class ClientServiceImpl implements ClientService {

    private final EmailMapper emailMapper;
    private final ClientMapper clientMapper;
    private final ClientRepository repository;
    private final TelefoneMapper telefoneMapper;
    private final ViaCepIntegrationClient viaCepIntegration;

    public ClientServiceImpl(EmailMapper emailMapper, ClientMapper clientMapper, ClientRepository repository, TelefoneMapper telefoneMapper, ViaCepIntegrationClient viaCepIntegration) {
        this.emailMapper = emailMapper;
        this.clientMapper = clientMapper;
        this.repository = repository;
        this.telefoneMapper = telefoneMapper;
        this.viaCepIntegration = viaCepIntegration;
    }

    @Override
    public ClientResponseDTO cadastrarCliente(ClientRequestDTO request) throws NegocialException {
        if (repository.findByCpf(request.getCpf()).isPresent()) {
            throw new NegocialException(BAD_REQUEST.value(), "Registro duplicado");
        }

        return clientMapper.toDto(repository.save(makeClient(request)));
    }

    @Override
    public ClientResponseDTO obterClientPorCpf(String cpf) throws NegocialException {
        return clientMapper.toDto(
                repository.findByCpf(cpf).orElseThrow(() -> new NegocialException(BAD_REQUEST.value(), "Registro não encontrado"))
        );
    }

    @Override
    public CEPIntegrationResponseDTO obterCep(String cep) throws NegocialException {
        try {
            return viaCepIntegration.getCep(cep);
        } catch (FeignException exception) {
            throw new NegocialException(BAD_REQUEST.value(), "Erro de integracão, Verifique seu CEP");
        }
    }
    
    private Cliente makeClient(ClientRequestDTO request) {
        return Cliente.builder()
                .cpf(request.getCpf())
                .nome(request.getNome())
                .endereco(makeEndereco(request))
                .emails(emailMapper.listEmailsToEntity(request.getEmails()))
                .telefones(telefoneMapper.listTelefonesToEntity(request.getTelefones()))
                .build();
    }

    private Endereco makeEndereco(ClientRequestDTO request) {
        return Endereco.builder()
                .bairro(request.getEndereco().getBairro())
                .cep(Long.valueOf(request.getEndereco().getCep()))
                .complemento(request.getEndereco().getComplemento())
                .uf(request.getEndereco().getUf())
                .logradouro(request.getEndereco().getLogradouro())
                .localidade(request.getEndereco().getLocalidade())
                .build();
    }

}
