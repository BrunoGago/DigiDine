package com.fiap.digidine.applications.ports.inbound;

import com.fiap.digidine.infrastructure.adapters.outbound.repositories.entities.ProductEntity;
import com.fiap.digidine.domain.model.enums.CategoryEnum;

import java.util.List;

public interface FindByCategoryInputPort {

    List<ProductEntity> findByCategory(CategoryEnum category);
}
