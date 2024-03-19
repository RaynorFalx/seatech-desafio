package com.seatech.clientapi.exception;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class NegocialException extends Exception {

    @JsonProperty("http-status")
    private int codigoStatusHttp;

    @JsonProperty("erro-causa")
    private String causaErro;

}
