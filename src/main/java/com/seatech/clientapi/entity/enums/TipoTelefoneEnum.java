package com.seatech.clientapi.entity.enums;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum TipoTelefoneEnum {

    CELULAR("CELULAR"),
    COMERCIAL("COMERCIAL"),
    RESIDENCIAL("RESIDENCIAL");

    TipoTelefoneEnum(String tipo) {
        this.tipo = tipo;
    }

    private final String tipo;

    public static boolean containsTipo(String tipo) {
        return Arrays.stream(TipoTelefoneEnum.values())
                .map(TipoTelefoneEnum::getTipo)
                .anyMatch(tipoEnum -> tipoEnum.equals(tipo));
    }
}
