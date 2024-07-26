package com.fiap.digidine.infrastructure.adapters.inbound.controllers.mappers;

import com.fiap.digidine.domain.model.CustomerModel;
import com.fiap.digidine.infrastructure.adapters.inbound.controllers.dtos.CustomerDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    @Mapping(target = "id", ignore = true)
    CustomerModel toCustomerModel(CustomerDto customerDto);

    CustomerDto toCustomerDto(CustomerModel customerModel);
}
