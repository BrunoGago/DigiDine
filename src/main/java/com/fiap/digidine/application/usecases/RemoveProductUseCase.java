package com.fiap.digidine.application.usecases;

import com.fiap.digidine.application.gateways.ProductGateway;

public class RemoveProductUseCase {

    private final ProductGateway productsGateway;

    public RemoveProductUseCase(ProductGateway productsGateway) {
        this.productsGateway = productsGateway;
    }

    public void remove(long productNumber){
        productsGateway.removeByProductNumber(productNumber);
    }
}
