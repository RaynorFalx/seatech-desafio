package com.seatech.clientapi.entity.dto.entity;

import com.seatech.clientapi.util.validator.TipoTelefone;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TelefoneDTO {

    private final static String INVALID = "Telefone inválido: Padrão incorreto: " +
            "10(Números para telefones fixos EX:6130124629) e 11(Números para celulares EX:619814747678)";

    @Pattern(regexp = "^\\d{2}\\s?\\d{4,5}\\s?\\d{4}$", message = INVALID)
    private String numero;

    @TipoTelefone
    private String tipo;

}
