package com.fiap.digidine.application.usecases;

import com.fiap.digidine.application.gateways.ProductGateway;
import com.fiap.digidine.domain.entities.Product;

public class CreateProductUseCase {
    private final ProductGateway productsGateway;

    public CreateProductUseCase(ProductGateway productsGateway) {
        this.productsGateway = productsGateway;
    }

    public void create(Product product) {
        productsGateway.create(product);
    }
}
