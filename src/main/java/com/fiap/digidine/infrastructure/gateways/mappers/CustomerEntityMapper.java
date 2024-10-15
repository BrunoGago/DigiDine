package com.fiap.digidine.infrastructure.gateways.mappers;

import com.fiap.digidine.domain.entities.Customer;
import com.fiap.digidine.infrastructure.persistence.entities.mongodb.CustomerEntity;

import java.util.ArrayList;
import java.util.List;

public class CustomerEntityMapper {

    public CustomerEntity toEntity(Customer customer){
        return new CustomerEntity(customer.getCpf(), customer.getName(), customer.getEmail());
    }

    public Customer toDomain(CustomerEntity entity){
        return new Customer(entity.getCpf(), entity.getName(), entity.getCpf());
    }

    public List<Customer> toDomains(List<CustomerEntity> entities){
        List<Customer> customers = new ArrayList<>();

        for (CustomerEntity entity : entities) {
            Customer customer = new Customer(
                    entity.getCpf(),
                    entity.getName(),
                    entity.getEmail()
            );
            customers.add(customer);
        }
        return customers;
    }
}
