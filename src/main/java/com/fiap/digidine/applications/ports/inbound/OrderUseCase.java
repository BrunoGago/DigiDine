package com.fiap.digidine.applications.ports.inbound;

import com.fiap.digidine.applications.core.domain.model.Order;

import java.util.List;

public interface OrderUseCase {
    Order createOrder(Order order);
    List<Order> listOrders();

}
