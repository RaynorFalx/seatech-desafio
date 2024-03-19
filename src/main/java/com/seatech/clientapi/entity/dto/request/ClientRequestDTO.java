package com.seatech.clientapi.entity.dto.request;

import com.seatech.clientapi.entity.dto.entity.EnderecoDTO;
import com.seatech.clientapi.entity.dto.entity.TelefoneDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ClientRequestDTO {

    private final static String BLANK = "Email inválido: Email vazio";
    private final static String INVALID = "Email inválido: Forneça um Email válido";
    private final static String NULL = "Email inválido: Forneça pelo menos um email";

    @NotBlank(message = "Nome inválido: Nome vazio")
    @NotNull(message = "Nome inválido: Nome nulo")
    @Size(min = 3, max = 100, message = "Nome inválido: Necessário ter entre 3 - 100 letras")
    private String nome;

    @NotNull(message = "CPF inválido: CPF nulo")
    private String cpf;

    @Valid
    private EnderecoDTO endereco;

    @Valid
    @Size(min = 1, message = "Telefone inválido: Telefone vazio")
    private List<TelefoneDTO> telefones;

    @NotEmpty(message = NULL)
    private List<@NotNull(message = NULL) @NotBlank(message = BLANK) @Email(message = INVALID) String> emails;

}
