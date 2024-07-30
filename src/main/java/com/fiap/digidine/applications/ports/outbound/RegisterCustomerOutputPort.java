package com.fiap.digidine.applications.ports.outbound;

import com.fiap.digidine.domain.model.CustomerModel;

public interface RegisterCustomerOutputPort {

    void registerCustomer(CustomerModel customer);
}
