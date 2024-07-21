package com.fiap.digidine.applications.service;

import com.fiap.digidine.domain.model.CustomerModel;
import com.fiap.digidine.applications.ports.inbound.CustomerUseCase;
import com.fiap.digidine.applications.ports.outbound.CustomerRepository;

import java.util.Optional;

public class CustomerService implements CustomerUseCase {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public CustomerModel registerCustomer(CustomerModel customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Optional<CustomerModel> identifyCustomer(String cpf) {
        return customerRepository.findByCpf(cpf);
    }
}
