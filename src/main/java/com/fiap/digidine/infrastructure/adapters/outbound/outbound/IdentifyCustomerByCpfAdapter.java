package com.fiap.digidine.infrastructure.adapters.outbound.outbound;

import com.fiap.digidine.applications.ports.outbound.IdentifyCustomerOutputPort;
import com.fiap.digidine.domain.model.CustomerModel;
import com.fiap.digidine.infrastructure.adapters.outbound.repositories.CustomerJpaRepository;
import com.fiap.digidine.infrastructure.adapters.outbound.repositories.mappers.CustomerEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class IdentifyCustomerByCpfAdapter implements IdentifyCustomerOutputPort{

    @Autowired
    private CustomerJpaRepository customerJpaRepository;

    @Autowired
    private CustomerEntityMapper customerEntityMapper;

    @Override
    public CustomerModel identifyCustomer(String cpf) {
        var customerEntity = customerJpaRepository.findByCpf(cpf);
        return customerEntityMapper.toCustomerModel(customerEntity);
    }
}
