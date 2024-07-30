package com.fiap.digidine.applications.ports.inbound;

import com.fiap.digidine.infrastructure.adapters.outbound.repositories.entities.OrderEntity;

import java.util.List;

public interface ListOrdersInputPort {

    List<OrderEntity> listOrders();
}
