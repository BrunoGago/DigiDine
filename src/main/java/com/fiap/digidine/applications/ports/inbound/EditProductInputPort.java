package com.fiap.digidine.applications.ports.inbound;

import com.fiap.digidine.infrastructure.adapters.outbound.repositories.entities.ProductEntity;

public interface EditProductInputPort {

    ProductEntity editProduct(ProductEntity product);
}
