package com.fiap.digidine.infrastructure.adapters.outbound;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fiap.digidine.applications.ports.outbound.ListOrdersOutputPort;
import com.fiap.digidine.domain.model.OrderModel;
import com.fiap.digidine.infrastructure.adapters.outbound.repositories.OrderJpaRepository;
import com.fiap.digidine.infrastructure.adapters.outbound.repositories.mappers.OrderEntityMapper;

@Component
public class ListOrderByIdAdapter implements ListOrdersOutputPort {

    @Autowired
    private OrderJpaRepository orderJpaRepository;

    @Autowired
    private OrderEntityMapper orderEntityMapper;

    @Override
    public OrderModel listOrders(UUID id) {
        var orderEntity = orderJpaRepository.findById(id);
        return orderEntityMapper.toOrderModel(orderEntity);
    }
    
}
