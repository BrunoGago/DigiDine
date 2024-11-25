package com.fiap.digidine.domain.entities;

public class Customer {

    private Long customerNumber;
    private String cpf; // Tax ID number
    private String name;
    private String email;

    public Customer() {
    }

    public Customer(Long customerNumber, String cpf, String name, String email) {
        this.customerNumber = customerNumber;
        this.cpf = cpf;
        this.name = name;
        this.email = email;
    }

    public Long getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(Long customerNumber) {
        this.customerNumber = customerNumber;
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
