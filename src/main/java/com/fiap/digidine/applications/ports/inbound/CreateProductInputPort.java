package com.fiap.digidine.applications.ports.inbound;

import com.fiap.digidine.domain.model.ProductModel;
import com.fiap.digidine.infrastructure.adapters.inbound.controllers.dtos.ProductDto;

public interface CreateProductInputPort {
    ProductModel createProduct(ProductDto product);
}
