package com.seatech.clientapi.controller;

import com.seatech.clientapi.entity.dto.entity.EnderecoDTO;
import com.seatech.clientapi.entity.dto.request.ClientRequestDTO;
import com.seatech.clientapi.entity.dto.response.CEPIntegrationResponseDTO;
import com.seatech.clientapi.entity.dto.response.ClientResponseDTO;
import com.seatech.clientapi.exception.NegocialException;
import com.seatech.clientapi.service.ClientServiceImpl;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/client")
public class ClientController {

    private ClientServiceImpl clientService;

    @PostMapping(value = "/cadastrarCliente")
    public ResponseEntity<ClientResponseDTO> save(@RequestBody @Valid ClientRequestDTO requestBody) throws NegocialException {
        return ResponseEntity.ok(clientService.cadastrarCliente(requestBody));
    }

    @GetMapping(value = "/obterClientPorCpf/{cpf}")
    public ResponseEntity<ClientResponseDTO> obterClientPorCpf(@PathVariable("cpf") String cpf) throws NegocialException {
        return ResponseEntity.ok(clientService.obterClientPorCpf(cpf));
    }

    @GetMapping(value = "/obterCep/{cep}")
    public ResponseEntity<CEPIntegrationResponseDTO> obterCep(@PathVariable("cep") String cep) throws NegocialException {
        return ResponseEntity.ok(clientService.obterCep(cep));
    }
}
