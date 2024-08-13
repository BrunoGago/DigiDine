package com.fiap.digidine.domain.ports.outbound;

import com.fiap.digidine.applications.dto.ProductDto;
import com.fiap.digidine.domain.model.CustomerModel;
import com.fiap.digidine.domain.model.ProductModel;

import java.util.Optional;
import java.util.UUID;

public interface ProductRepositoryPort {
    void create(ProductModel product);
    Optional<ProductModel> get(UUID id);
    void update(ProductModel product);
    void remove(UUID id);
}
