package com.seatech.clientapi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TB_TELEFONE")
public class Telefone {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CO_SEQ_TELEFONE")
    private Long telefoneId;

    @Column(name = "DS_NUMERO")
    private String numero;

    @Column(name = "DS_TIPO")
    private String tipo;

}
