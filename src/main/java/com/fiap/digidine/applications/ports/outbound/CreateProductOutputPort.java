package com.fiap.digidine.applications.ports.outbound;

import com.fiap.digidine.domain.model.ProductModel;

public interface CreateProductOutputPort {
    ProductModel createProduct(ProductModel product);
}
