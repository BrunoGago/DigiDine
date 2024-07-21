package com.fiap.digidine.domain.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fiap.digidine.domain.exception.DomainException;
import jakarta.persistence.*;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "TB_CUSTOMER")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomerModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column
    private String cpf;

    private String name;

    private String email;

    public CustomerModel() {
    }

    public CustomerModel(UUID id, String cpf, String name, String email) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CustomerModel customer)) return false;
        return Objects.equals(getId(), customer.getId()) && Objects.equals(getCpf(), customer.getCpf()) && Objects.equals(getName(), customer.getName()) && Objects.equals(getEmail(), customer.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCpf(), getName(), getEmail());
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", cpf='" + cpf + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public void validateCpf() {
        if (this.cpf == null || !this.cpf.matches("\\d{11}")) {
            throw new DomainException("Invalid CPF format. CPF must be 11 digits.");
        }
    }
}
