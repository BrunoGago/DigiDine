package com.fiap.digidine.application.usecases;

import com.fiap.digidine.application.gateways.ProductGateway;
import com.fiap.digidine.domain.entities.Product;

public class UpdateProductUseCase {
    private final ProductGateway productsGateway;

    public UpdateProductUseCase(ProductGateway productsGateway) {
        this.productsGateway = productsGateway;
    }

    public Product update(String id, Product request) {
        return productsGateway.updateById(id, request);
    }

}