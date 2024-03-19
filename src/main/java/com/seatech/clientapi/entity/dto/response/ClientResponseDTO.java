package com.seatech.clientapi.entity.dto.response;

import com.seatech.clientapi.entity.Email;
import com.seatech.clientapi.entity.Endereco;
import com.seatech.clientapi.entity.Telefone;
import com.seatech.clientapi.entity.dto.entity.EnderecoDTO;
import com.seatech.clientapi.entity.dto.entity.TelefoneDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClientResponseDTO {

    private Long cpf;
    private String nome;
    private List<TelefoneDTO> telefones;
    private List<String> emails;
    private Endereco endereco;

}
