package com.fiap.digidine.applications.ports.outbound;

import com.fiap.digidine.infrastructure.adapters.outbound.repositories.entities.ProductEntity;

public interface EditProductOutputPort {

    ProductEntity editProduct(ProductEntity product);
}
