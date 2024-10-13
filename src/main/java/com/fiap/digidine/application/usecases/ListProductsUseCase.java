package com.fiap.digidine.application.usecases;

import com.fiap.digidine.application.gateways.ProductGateway;
import com.fiap.digidine.domain.entities.Product;

import java.util.List;

public class ListProductsUseCase {
    private final ProductGateway productsGateway;

    public ListProductsUseCase(ProductGateway productsGateway) {
        this.productsGateway = productsGateway;
    }

    public List<Product> listProducts() {
        return productsGateway.list();
    }
}
