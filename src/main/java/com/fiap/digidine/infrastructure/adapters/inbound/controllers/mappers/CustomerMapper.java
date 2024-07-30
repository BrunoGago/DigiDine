package com.fiap.digidine.infrastructure.adapters.inbound.controllers.mappers;


import com.fiap.digidine.domain.model.CustomerModel;
import com.fiap.digidine.infrastructure.adapters.inbound.controllers.dtos.CustomerDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    public static final CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    @Mapping(target = "id", ignore = true)
    CustomerModel toCustomerModel(CustomerDto customerDto);

    CustomerDto toCustomerDto(CustomerModel customerModel);
}
