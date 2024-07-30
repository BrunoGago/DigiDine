package com.fiap.digidine.applications.ports.outbound;

import com.fiap.digidine.infrastructure.adapters.outbound.repositories.entities.ProductEntity;
import com.fiap.digidine.domain.model.enums.CategoryEnum;

import java.util.List;

public interface FindByCategoryOutputPort {

    List<ProductEntity> findByCategory(CategoryEnum category);
}
