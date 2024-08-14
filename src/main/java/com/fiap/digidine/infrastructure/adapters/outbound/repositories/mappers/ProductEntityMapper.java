package com.fiap.digidine.infrastructure.adapters.outbound.repositories.mappers;

import com.fiap.digidine.domain.model.CustomerModel;
import com.fiap.digidine.domain.model.ProductModel;
import com.fiap.digidine.infrastructure.adapters.outbound.repositories.entities.CustomerEntity;
import com.fiap.digidine.infrastructure.adapters.outbound.repositories.entities.ProductEntity;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ProductEntityMapper {

    public ProductEntity toEntity(ProductModel model) {
        if (model == null) {
            return null;
        }

        ProductEntity entity = new ProductEntity();
        entity.setId(UUID.randomUUID());
        entity.setDescription(model.getDescription());
        entity.setName(model.getName());
        entity.setPrice(model.getPrice());
        entity.setCategory(model.getCategory());

        return entity;
    }

    public ProductModel toModel(ProductEntity entity) {
        if (entity == null) {
            return null;
        }

        ProductModel model = new ProductModel();
        model.setId(entity.getId());
        model.setPrice(entity.getPrice());
        model.setName(entity.getName());
        model.setDescription(entity.getDescription());
        model.setCategory(entity.getCategory());

        return model;
    }
}
