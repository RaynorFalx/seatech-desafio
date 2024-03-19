package com.seatech.clientapi.service;

import com.seatech.clientapi.entity.dto.request.ClientRequestDTO;
import com.seatech.clientapi.entity.dto.response.CEPIntegrationResponseDTO;
import com.seatech.clientapi.entity.dto.response.ClientResponseDTO;
import com.seatech.clientapi.exception.NegocialException;

import java.util.List;

public interface ClientService {

    ClientResponseDTO cadastrarCliente(ClientRequestDTO request) throws NegocialException;
    ClientResponseDTO obterClientPorCpf(String cpf) throws NegocialException;
    CEPIntegrationResponseDTO obterCep(String cep) throws NegocialException;

}
