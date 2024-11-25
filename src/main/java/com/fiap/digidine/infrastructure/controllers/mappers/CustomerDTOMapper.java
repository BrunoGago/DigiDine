package com.fiap.digidine.infrastructure.controllers.mappers;

import com.fiap.digidine.domain.entities.Customer;
import com.fiap.digidine.infrastructure.controllers.dtos.CustomerRequest;
import com.fiap.digidine.infrastructure.controllers.dtos.CustomerResponse;

public class CustomerDTOMapper {
    CustomerResponse toResponse(Customer customer){
        return new CustomerResponse(customer.getCustomerNumber(), customer.getCpf(), customer.getName(), customer.getEmail());
    }

    public Customer toCustomer(CustomerRequest request){
        return new Customer(null, request.cpf(), request.name(), request.email());
    }
}
