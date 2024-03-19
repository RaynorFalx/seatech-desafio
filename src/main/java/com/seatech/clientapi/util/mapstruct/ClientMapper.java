package com.seatech.clientapi.util.mapstruct;

import com.seatech.clientapi.entity.Cliente;
import com.seatech.clientapi.entity.Email;
import com.seatech.clientapi.entity.Endereco;
import com.seatech.clientapi.entity.dto.entity.EnderecoDTO;
import com.seatech.clientapi.entity.dto.response.ClientResponseDTO;
import org.mapstruct.*;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN)
public interface ClientMapper {

    ClientResponseDTO toDto(Cliente etity);
    List<ClientResponseDTO> toDtoList(List<Cliente> entityList);

    default EnderecoDTO toDtoEnderecoDTOType(Endereco endereco) {
        return EnderecoDTO.builder()
                .cep(endereco.getCep().toString())
                .uf(endereco.getUf())
                .localidade(endereco.getLocalidade())
                .bairro(endereco.getBairro())
                .logradouro(endereco.getLogradouro())
                .build();
    }

    default List<String> toDtoEmailListType(List<Email> emailList) {
        return emailList.stream()
                .map(Email::getEmail)
                .collect(Collectors.toList());
    }

}
