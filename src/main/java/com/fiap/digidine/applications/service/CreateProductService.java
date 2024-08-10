package com.fiap.digidine.applications.service;

import com.fiap.digidine.applications.ports.inbound.CreateProductInputPort;
import com.fiap.digidine.applications.ports.outbound.CreateProductOutputPort;
import com.fiap.digidine.domain.model.ProductModel;
import com.fiap.digidine.infrastructure.adapters.inbound.controllers.dtos.ProductDto;
import com.fiap.digidine.infrastructure.adapters.outbound.repositories.entities.ProductEntity;

public class CreateProductService implements CreateProductInputPort {

    private CreateProductOutputPort createProductOutputPort;

    public CreateProductService(CreateProductOutputPort createProductOutputPort) {
        this.createProductOutputPort = createProductOutputPort;
    }

    @Override
    public ProductModel createProduct(ProductDto productDto) {
        return createProductOutputPort.createProduct(productDto);
    }
}

