package com.fiap.digidine.applications.ports.outbound;

import com.fiap.digidine.infrastructure.adapters.outbound.repositories.entities.OrderEntity;

import java.util.List;

public interface ListOrdersOutputPort {

    List<OrderEntity> listOrders();
}
