package com.fiap.digidine.application.gateways;

import com.fiap.digidine.domain.entities.Customer;

import java.util.List;

public interface CustomerGateway {
    Customer register(Customer customer);
    Customer getByCpf(String cpf);
    List<Customer> list();
}
