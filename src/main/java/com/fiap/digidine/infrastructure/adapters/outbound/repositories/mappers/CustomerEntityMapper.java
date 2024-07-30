package com.fiap.digidine.infrastructure.adapters.outbound.repositories.mappers;

import com.fiap.digidine.domain.model.CustomerModel;
import com.fiap.digidine.infrastructure.adapters.inbound.controllers.mappers.CustomerMapper;
import com.fiap.digidine.infrastructure.adapters.outbound.repositories.entities.CustomerEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CustomerEntityMapper {

    public static final CustomerEntityMapper INSTANCE = Mappers.getMapper(CustomerEntityMapper.class);

    CustomerEntity toCustomerEntity(CustomerModel customerModel);

    CustomerModel toCustomerModel(CustomerEntity customerEntity);

}
