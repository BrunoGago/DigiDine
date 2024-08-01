package com.fiap.digidine.applications.service;

import com.fiap.digidine.applications.ports.inbound.CreateProductInputPort;
import com.fiap.digidine.applications.ports.outbound.CreateProductOutputPort;
import com.fiap.digidine.infrastructure.adapters.outbound.repositories.entities.ProductEntity;

public class CreateProductService implements CreateProductInputPort {

    private CreateProductOutputPort createProductOutputPort;

    public CreateProductService(CreateProductOutputPort createProductOutputPort) {
        this.createProductOutputPort = createProductOutputPort;
    }

    @Override
    public ProductEntity createProduct(ProductEntity product) {
        return createProductOutputPort.createProduct(product);
    }
}

