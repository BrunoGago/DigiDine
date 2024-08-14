package com.fiap.digidine.applications.ports.inbound;


import com.fiap.digidine.applications.dto.ProductDto;
import com.fiap.digidine.domain.model.enums.CategoryEnum;

import java.util.List;
import java.util.UUID;

public interface ProductServicePort {

    void create(ProductDto productDto);
    ProductDto get(UUID id);
    void update(UUID id, ProductDto productDto);
    void remove(UUID id);

    List<ProductDto> findByCategory(CategoryEnum category);
}
