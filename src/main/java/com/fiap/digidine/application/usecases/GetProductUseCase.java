package com.fiap.digidine.application.usecases;

import com.fiap.digidine.application.gateways.ProductGateway;
import com.fiap.digidine.domain.entities.Product;

public class GetProductUseCase {

    private final ProductGateway productsGateway;

    public GetProductUseCase(ProductGateway productsGateway) {
        this.productsGateway = productsGateway;
    }

    public Product get(String id){
        return productsGateway.getById(id);
    }
}
