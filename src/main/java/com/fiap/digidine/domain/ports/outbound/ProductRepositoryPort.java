package com.fiap.digidine.domain.ports.outbound;

import com.fiap.digidine.applications.dto.ProductDto;
import com.fiap.digidine.domain.model.CustomerModel;

import java.util.Optional;
import java.util.UUID;

public interface ProductRepositoryPort {
    ProductDto create(ProductDto product);
    Optional<ProductDto> get(UUID id);
}
