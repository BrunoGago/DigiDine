package com.fiap.digidine.infrastructure.adapters.outbound.repositories.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import org.hibernate.validator.constraints.br.CPF;

import java.util.UUID;

@Entity
@Table(name = "TB_CUSTOMER")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column
    @CPF
    private String cpf;

    @Column
    private String name;

    @Column
    @Email
    private String email;

    public CustomerEntity() {
    }

    public CustomerEntity(UUID id, String cpf, String name, String email) {
        this.id = id;
        this.cpf = cpf;
        this.name = name;
        this.email = email;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
