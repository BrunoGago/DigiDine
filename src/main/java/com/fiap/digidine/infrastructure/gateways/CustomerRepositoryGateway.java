package com.fiap.digidine.infrastructure.gateways;

import com.fiap.digidine.application.gateways.CustomerGateway;
import com.fiap.digidine.domain.entities.Customer;
import com.fiap.digidine.infrastructure.gateways.mappers.CustomerEntityMapper;
import com.fiap.digidine.infrastructure.persistence.CustomerRepository;
import com.fiap.digidine.infrastructure.persistence.entities.CustomerEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CustomerRepositoryGateway implements CustomerGateway {

    private final CustomerRepository customerRepository;
    private final CustomerEntityMapper customerEntityMapper;

    @Autowired
    public CustomerRepositoryGateway(CustomerRepository customerRepository, CustomerEntityMapper customerEntityMapper) {
        this.customerRepository = customerRepository;
        this.customerEntityMapper = customerEntityMapper;
    }

    @Override
    public Customer register(Customer customer) {
        return customerEntityMapper.toDomain(customerRepository.save(customerEntityMapper.toEntity(customer)));
    }

    @Override
    public Customer getByCpf(String cpf) {
        CustomerEntity customerEntity = customerRepository.findById(cpf).orElse(null);
        if (customerEntity == null) {
            throw new IllegalArgumentException("Cliente não encontrado!");
        }
        return customerEntityMapper.toDomain(customerEntity);
    }

    @Override
    public List<Customer> list() {
        return customerEntityMapper.toDomains(customerRepository.findAll());
    }
}
