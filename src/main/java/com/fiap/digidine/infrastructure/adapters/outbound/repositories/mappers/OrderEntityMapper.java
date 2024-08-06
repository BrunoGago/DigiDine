package com.fiap.digidine.infrastructure.adapters.outbound.repositories.mappers;

import org.mapstruct.factory.Mappers;

import com.fiap.digidine.infrastructure.adapters.outbound.repositories.entities.OrderEntity;

public class OrderEntityMapper {
    
 public static final OrderEntityMapper INSTANCE = Mappers.getMapper(OrderEntityMapper.class);

 public OrderEntity toOrderEntity(OrderEntity orderEntity);

}
