package com.fiap.digidine.applications.ports.inbound;

import com.fiap.digidine.domain.model.OrderModel;

public interface CreateOrderInputPort {
    OrderModel createOrder(OrderModel order);

}
