package com.seatech.clientapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ENDERECO")
public class Endereco {

    @Id
    @Column(name = "CO_CEP")
    private Long cep;

    @Column(name = "DS_LOGRADOURO")
    private String logradouro;

    @Column(name = "DS_COMPLEMENTO")
    private String complemento;

    @Column(name = "DS_BAIRRO")
    private String bairro;

    @Column(name = "DS_LOCALIDADE")
    private String localidade;

    @Column(name = "SG_UF")
    private String uf;

    @Column(name = "DS_IBGE")
    private String ibge;

    @Column(name = "DS_GIA")
    private String gia;

    @Column(name = "SG_DDD")
    private String ddd;

    @Column(name = "DS_SIAF")
    private String siafi;

}
