package com.fiap.digidine.applications.ports.outbound;

import com.fiap.digidine.domain.model.CustomerModel;

import java.util.Optional;

public interface IdentifyCustomerOutputPort {

    CustomerModel identifyCustomer(String cpf);
}
