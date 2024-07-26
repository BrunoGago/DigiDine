package com.fiap.digidine.applications.ports.outbound;

import com.fiap.digidine.domain.model.ProductModel;

public interface EditProductOutputPort {

    ProductModel editProduct(ProductModel product);
}
