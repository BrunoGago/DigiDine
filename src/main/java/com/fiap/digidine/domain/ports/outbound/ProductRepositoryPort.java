package com.fiap.digidine.domain.ports.outbound;

import com.fiap.digidine.domain.model.ProductModel;
import com.fiap.digidine.domain.model.enums.CategoryEnum;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductRepositoryPort {
    void create(ProductModel product);
    Optional<ProductModel> getById(UUID id);
    void update(ProductModel product);
    void removeById(UUID id);

    Optional<ProductModel> getByCategory(CategoryEnum category);
}
