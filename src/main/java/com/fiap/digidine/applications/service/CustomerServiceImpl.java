package com.fiap.digidine.applications.service;

import com.fiap.digidine.applications.dto.CustomerDto;
import com.fiap.digidine.applications.mappers.CustomerMapper;
import com.fiap.digidine.applications.ports.inbound.CustomerServicePort;
import com.fiap.digidine.domain.exception.DomainException;
import com.fiap.digidine.domain.model.CustomerModel;
import com.fiap.digidine.domain.ports.outbound.CustomerRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerServicePort {

    @Autowired
    private CustomerRepositoryPort customerRepositoryPort;

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public void registerCustomer(CustomerDto customerDto) {
        Optional<CustomerModel> byCpf = customerRepositoryPort.findByCpf(customerDto.getCpf());
        if(byCpf.isEmpty())
        {
            customerRepositoryPort.save(customerMapper.toModel(customerDto));
        }
        else
        {
            throw new DomainException("CPF já cadastrado!");
        }
    }

    @Override
    public CustomerDto getCustomerByCpf(String cpf) {
        return customerMapper.toDto(customerRepositoryPort.findByCpf(cpf)
                .orElseThrow(() -> new RuntimeException("Customer not found with CPF: " + cpf)));
    }
}


