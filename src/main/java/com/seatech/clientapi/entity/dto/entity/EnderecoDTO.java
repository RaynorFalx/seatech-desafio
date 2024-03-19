package com.seatech.clientapi.entity.dto.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoDTO {

    @Pattern(regexp = "^\\d{8}$", message = "CEP inválido: Forneça um CEP válido")
    private String cep;

    @NotNull(message = "UF inválida: UF nula")
    @NotBlank(message = "UF inválida: UF vazia")
    private String uf;

    @NotNull(message = "Bairro inválido: Bairro nulo")
    @NotBlank(message = "Bairro inválido: Bairro vazio")
    private String bairro;

    @NotNull(message = "Localidade/Cidade inválida: Localidade/Cidade nula")
    @NotBlank(message = "Localidade/Cidade inválida: Localidade/Cidade vazia")
    private String localidade;

    @NotNull(message = "Logradouro inválido: Logradouro nulo")
    @NotBlank(message = "Logradouro inválido: Logradouro vazio")
    private String logradouro;

    private String complemento;

}
