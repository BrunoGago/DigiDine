package com.fiap.digidine.applications.service;

import com.fiap.digidine.applications.dto.CustomerDto;
import com.fiap.digidine.applications.dto.ProductDto;
import com.fiap.digidine.applications.mappers.CustomerMapper;
import com.fiap.digidine.applications.ports.inbound.CustomerServicePort;
import com.fiap.digidine.applications.ports.inbound.ProductServicePort;
import com.fiap.digidine.domain.ports.outbound.CustomerRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductServicePort {

    @Autowired
    private CustomerRepositoryPort customerRepositoryPort;

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public void create(ProductDto productDto) {

    }

    @Override
    public ProductDto get(UUID id) {
        return null;
    }

}


