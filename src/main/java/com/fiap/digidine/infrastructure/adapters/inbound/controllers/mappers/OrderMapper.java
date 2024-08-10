package com.fiap.digidine.infrastructure.adapters.inbound.controllers.mappers;

import com.fiap.digidine.domain.model.OrderModel;
import com.fiap.digidine.infrastructure.adapters.inbound.controllers.dtos.OrderDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    @Mapping(target = "id", ignore = true) 
    OrderModel toOrderModel(OrderDto orderDto);

    OrderDto toOrderDto(OrderModel orderModel);

    List<OrderDto> toOrderDtoList(List<OrderModel> orderModels); 
}
