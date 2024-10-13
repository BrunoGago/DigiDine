package com.fiap.digidine.application.usecases;

import com.fiap.digidine.application.gateways.CustomerGateway;
import com.fiap.digidine.domain.entities.Customer;

import java.util.List;

public class ListCustomersUseCase {
    private final CustomerGateway customersGateway;

    public ListCustomersUseCase(CustomerGateway customersGateway) {
        this.customersGateway = customersGateway;
    }

    public List<Customer> execute() {
        return customersGateway.list();
    }
}
