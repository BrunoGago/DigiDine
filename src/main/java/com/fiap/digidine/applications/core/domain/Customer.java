package com.fiap.digidine.applications.core.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "TB_CUSTOMER")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column
    private String cpf;

    private String name;

    private String email;
}
