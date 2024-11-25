package com.fiap.digidine.infrastructure.persistence.entities.mongodb;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "customers") // Define a coleção do MongoDB
public class CustomerEntity {

    @Id // Define o identificador do documento
    private String id;
    private long customerNumber;
    @CPF
    private String cpf;
    private String name;
    private String email;

    public CustomerEntity() {
    }

    public CustomerEntity(long customerNumber, String cpf, String name, String email) {
        this.customerNumber = customerNumber;
        this.cpf = cpf;
        this.name = name;
        this.email = email;
    }

    public long getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(long customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
