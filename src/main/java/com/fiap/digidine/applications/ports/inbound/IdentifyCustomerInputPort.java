package com.fiap.digidine.applications.ports.inbound;

import com.fiap.digidine.domain.model.CustomerModel;

import java.util.Optional;

public interface IdentifyCustomerInputPort {

    CustomerModel identifyCustomer(String cpf);
}