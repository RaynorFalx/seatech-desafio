package com.seatech.clientapi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TB_EMAIL")
public class Email {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long emailId;

    @Column(name = "DS_EMAIL")
    private String email;

}
