package com.fiap.digidine.infrastructure.adapters.outbound.repositories.mappers;

import com.fiap.digidine.domain.model.CustomerModel;
import com.fiap.digidine.infrastructure.adapters.outbound.repositories.entities.CustomerEntity;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
public class CustomerEntityMapper {

    // Mapeia um CustomerModel para um CustomerEntity
    public CustomerEntity toEntity(CustomerModel model) {
        if (model == null) {
            return null;
        }

        CustomerEntity entity = new CustomerEntity();
        entity.setId(model.getId());
        entity.setCpf(model.getCpf());
        entity.setName(model.getName());
        entity.setEmail(model.getEmail());

        return entity;
    }

    // Mapeia um CustomerEntity para um CustomerModel
    public CustomerModel toModel(CustomerEntity entity) {
        if (entity == null) {
            return null;
        }

        CustomerModel model = new CustomerModel();
        model.setId(entity.getId());
        model.setCpf(entity.getCpf());
        model.setName(entity.getName());
        model.setEmail(entity.getEmail());

        return model;
    }
}
