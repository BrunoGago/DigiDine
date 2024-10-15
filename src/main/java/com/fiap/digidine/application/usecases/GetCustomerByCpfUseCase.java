package com.fiap.digidine.application.usecases;

import com.fiap.digidine.application.gateways.CustomerGateway;
import com.fiap.digidine.domain.entities.Customer;

public class GetCustomerByCpfUseCase {

    private final CustomerGateway customersGateway;

    public GetCustomerByCpfUseCase(CustomerGateway customersGateway){
        this.customersGateway = customersGateway;
    }

    public Customer getCustomerByCpf(String cpf){
        return customersGateway.getByCpf(cpf);
    }
}
