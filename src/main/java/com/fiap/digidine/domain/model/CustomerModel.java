package com.fiap.digidine.domain.model;

import java.util.UUID;

public class CustomerModel {

    private UUID id;

    private String cpf;

    private String name;

    private String email;

    public CustomerModel() {
    }

    public CustomerModel(UUID id, String cpf, String name, String email) {
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
