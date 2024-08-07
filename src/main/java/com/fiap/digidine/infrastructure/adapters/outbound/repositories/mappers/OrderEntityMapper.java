package com.fiap.digidine.infrastructure.adapters.outbound.repositories.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.fiap.digidine.domain.model.OrderModel;
import com.fiap.digidine.infrastructure.adapters.outbound.repositories.entities.OrderEntity;

@Mapper(componentModel = "spring")
public interface OrderEntityMapper {
   
 public static final OrderEntityMapper INSTANCE = Mappers.getMapper(OrderEntityMapper.class);

 OrderEntity toOrderEntity(OrderEntity order);

 OrderModel toOrderModel(OrderEntity orderEntity);
 

}