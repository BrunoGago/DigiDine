package com.fiap.digidine.infrastructure.adapters.outbound.outbound;

import com.fiap.digidine.applications.ports.outbound.RegisterCustomerOutputPort;
import com.fiap.digidine.domain.model.CustomerModel;
import com.fiap.digidine.infrastructure.adapters.outbound.repositories.CustomerJpaRepository;
import com.fiap.digidine.infrastructure.adapters.outbound.repositories.mappers.CustomerEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RegisterCustomerAdapter implements RegisterCustomerOutputPort {

    @Autowired
    private CustomerJpaRepository customerJpaRepository;

    @Autowired
    private CustomerEntityMapper customerEntityMapper;

    @Override
    public void registerCustomer(CustomerModel customer) {
        var customerEntity = customerEntityMapper.toCustomerEntity(customer);
        customerJpaRepository.save(customerEntity);
    }
}
