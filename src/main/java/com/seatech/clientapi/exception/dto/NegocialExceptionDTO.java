package com.seatech.clientapi.exception.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NegocialExceptionDTO {

    @JsonProperty("http-status")
    private int codigoStatusHttp;

    @JsonProperty("erro-causa")
    private String causaErro;

}
