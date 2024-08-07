package com.fiap.digidine.applications.ports.outbound;

import com.fiap.digidine.domain.model.ProductModel;
import com.fiap.digidine.infrastructure.adapters.inbound.controllers.dtos.ProductDto;

public interface CreateProductOutputPort {
    ProductModel createProduct(ProductDto product);
}
