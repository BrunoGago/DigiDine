package com.fiap.digidine.applications.service;

import com.fiap.digidine.applications.ports.inbound.RegisterCustomerInputPort;
import com.fiap.digidine.applications.ports.outbound.RegisterCustomerOutputPort;
import com.fiap.digidine.domain.model.CustomerModel;
import org.springframework.stereotype.Service;

@Service
public class RegisterCustomerService implements RegisterCustomerInputPort {

    private RegisterCustomerOutputPort registerCustomerOutputPort;

    public RegisterCustomerService(RegisterCustomerOutputPort registerCustomerOutputPort) {
        this.registerCustomerOutputPort = registerCustomerOutputPort;
    }

    @Override
    public void registerCustomer(CustomerModel customer) {
        registerCustomerOutputPort.registerCustomer(customer);
    }
}
