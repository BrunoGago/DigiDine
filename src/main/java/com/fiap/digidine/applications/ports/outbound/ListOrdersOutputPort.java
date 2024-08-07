package com.fiap.digidine.applications.ports.outbound;

import com.fiap.digidine.domain.model.OrderModel;

import java.util.UUID;

public interface ListOrdersOutputPort {
    OrderModel listOrders(UUID id);
}
