package com.fiap.digidine.infrastructure.adapters.outbound;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fiap.digidine.applications.ports.outbound.CreateOrderOutputPort;

import com.fiap.digidine.infrastructure.adapters.outbound.repositories.OrderJpaRepository;
import com.fiap.digidine.infrastructure.adapters.outbound.repositories.entities.OrderEntity;
import com.fiap.digidine.infrastructure.adapters.outbound.repositories.mappers.OrderEntityMapper;

@Component
public class CreateOrderAdapter implements CreateOrderOutputPort {
    
    @Autowired
    private OrderJpaRepository orderJpaRepository;

    @Autowired 
    private OrderEntityMapper orderEntityMapper;

    @Override
    public OrderEntity createOrder(OrderEntity order){
        var orderEntity = orderEntityMapper.toOrderEntity(order);
        return orderJpaRepository.save(orderEntity);
    }

}