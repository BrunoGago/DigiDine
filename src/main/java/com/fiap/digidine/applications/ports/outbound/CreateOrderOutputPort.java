package com.fiap.digidine.applications.ports.outbound;

import com.fiap.digidine.infrastructure.adapters.outbound.repositories.entities.OrderEntity;

public interface CreateOrderOutputPort {
    OrderEntity createOrder(OrderEntity order);

}
