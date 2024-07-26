package com.fiap.digidine.applications.ports.inbound;

import com.fiap.digidine.infrastructure.adapters.outbound.repositories.entities.OrderEntity;

public interface CreateOrderInputPort {
    OrderEntity createOrder(OrderEntity order);

}
