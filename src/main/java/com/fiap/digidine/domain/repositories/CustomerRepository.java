package com.fiap.digidine.domain.repositories;

import com.fiap.digidine.domain.entities.Customer;

import java.util.List;

public interface CustomerRepository {
    Customer save(Customer customer);
    Customer findById(String cpf);
    List<Customer> listCustomers();
    void update(Customer customer);
    void delete(String cpf);
}
