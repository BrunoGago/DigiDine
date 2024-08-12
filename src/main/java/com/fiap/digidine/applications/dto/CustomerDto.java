package com.fiap.digidine.applications.dto;

import jakarta.validation.constraints.Email;
import org.hibernate.validator.constraints.br.CPF;

public class CustomerDto {

    @CPF
    private String cpf;

    private String name;

    @Email
    private String email;

    public CustomerDto(String cpf, String name, String email) {
        this.cpf = cpf;
        this.name = name;
        this.email = email;
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
