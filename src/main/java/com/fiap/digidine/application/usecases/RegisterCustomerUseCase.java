package com.fiap.digidine.application.usecases;

import com.fiap.digidine.application.gateways.CustomerGateway;
import com.fiap.digidine.domain.entities.Customer;

public class RegisterCustomerUseCase {
    private final CustomerGateway customersGateway;

    public RegisterCustomerUseCase(CustomerGateway customersGateway) {
        this.customersGateway = customersGateway;
    }

    public void registerCustomer(Customer customer) {
        customersGateway.register(customer);
    }
}
