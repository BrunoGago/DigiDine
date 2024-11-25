package com.fiap.digidine.infrastructure.gateways;

import com.fiap.digidine.application.gateways.CustomerGateway;
import com.fiap.digidine.domain.entities.Customer;
import com.fiap.digidine.infrastructure.gateways.mappers.CustomerEntityMapper;
import com.fiap.digidine.infrastructure.persistence.CustomerMongoDBRepository;
import com.fiap.digidine.infrastructure.persistence.entities.mongodb.CustomerEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CustomerRepositoryGateway implements CustomerGateway {

    private final CustomerMongoDBRepository customerRepository;
    private final CustomerEntityMapper customerEntityMapper;

    public CustomerRepositoryGateway(CustomerMongoDBRepository customerRepository, CustomerEntityMapper customerEntityMapper) {
        this.customerRepository = customerRepository;
        this.customerEntityMapper = customerEntityMapper;
    }

    @Override
    public Customer register(Customer customer) {
        // Obter o último número de cliente
        CustomerEntity lastCustomer = customerRepository.findFirstByOrderByCustomerNumberDesc();
        long nextCustomerNumber = (lastCustomer != null ? lastCustomer.getCustomerNumber() : 0) + 1;

        // Configurar o novo número de cliente
        customer.setCustomerNumber(nextCustomerNumber);

        return customerEntityMapper.toDomain(customerRepository.save(customerEntityMapper.toEntity(customer)));
    }

    @Override
    public Customer getByCpf(String cpf) {
        CustomerEntity customerEntity = customerRepository.findByCpf(cpf);
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
