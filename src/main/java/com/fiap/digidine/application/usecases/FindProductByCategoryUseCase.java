package com.fiap.digidine.application.usecases;

import com.fiap.digidine.application.gateways.ProductGateway;
import com.fiap.digidine.domain.entities.Product;
import com.fiap.digidine.domain.entities.enums.Category;

import java.util.List;

public class FindProductByCategoryUseCase {

    private final ProductGateway productsGateway;

    public FindProductByCategoryUseCase(ProductGateway productsGateway) {
        this.productsGateway = productsGateway;
    }

    public List<Product> findByCategory(Category category){
        return productsGateway.findByCategory(category);
    }
}
