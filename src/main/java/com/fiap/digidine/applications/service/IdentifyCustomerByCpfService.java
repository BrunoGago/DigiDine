package com.fiap.digidine.applications.service;

import com.fiap.digidine.applications.ports.inbound.IdentifyCustomerInputPort;
import com.fiap.digidine.applications.ports.outbound.IdentifyCustomerOutputPort;
import com.fiap.digidine.domain.model.CustomerModel;
import org.springframework.stereotype.Service;

@Service
public class IdentifyCustomerByCpfService implements IdentifyCustomerInputPort {

    private IdentifyCustomerOutputPort identifyCustomerOutputPort;

    public IdentifyCustomerByCpfService(IdentifyCustomerOutputPort identifyCustomerOutputPort) {
        this.identifyCustomerOutputPort = identifyCustomerOutputPort;
    }

    @Override
    public CustomerModel identifyCustomer(String cpf) {
        return identifyCustomerOutputPort.identifyCustomer(cpf);
    }
}
