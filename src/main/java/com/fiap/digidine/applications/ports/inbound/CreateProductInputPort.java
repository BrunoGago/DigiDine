package com.fiap.digidine.applications.ports.inbound;

import com.fiap.digidine.domain.model.ProductModel;

public interface CreateProductInputPort {
    ProductModel createProduct(ProductModel product);
}
