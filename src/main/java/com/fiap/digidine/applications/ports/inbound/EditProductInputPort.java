package com.fiap.digidine.applications.ports.inbound;

import com.fiap.digidine.domain.model.ProductModel;
import com.fiap.digidine.infrastructure.adapters.inbound.controllers.dtos.ProductDto;
import java.util.UUID;

public interface EditProductInputPort {

    ProductModel editProduct(ProductDto product, UUID id);
}
