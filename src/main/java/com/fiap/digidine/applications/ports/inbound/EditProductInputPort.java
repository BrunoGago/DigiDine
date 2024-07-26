package com.fiap.digidine.applications.ports.inbound;

import com.fiap.digidine.domain.model.ProductModel;

public interface EditProductInputPort {

    ProductModel editProduct(ProductModel product);
}
