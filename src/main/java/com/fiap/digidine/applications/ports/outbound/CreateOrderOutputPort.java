package com.fiap.digidine.applications.ports.outbound;

import com.fiap.digidine.domain.model.OrderModel;

public interface CreateOrderOutputPort {
    OrderModel createOrder(OrderModel order);

}
