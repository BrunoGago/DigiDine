package com.fiap.digidine.application.usecases;

import com.fiap.digidine.application.gateways.OrderGateway;
import com.fiap.digidine.domain.entities.Order;

import java.util.List;

public class ListOrdersUseCase {
    private final OrderGateway ordersGateway;

    public ListOrdersUseCase(OrderGateway ordersGateway) {
        this.ordersGateway = ordersGateway;
    }

    public List<Order> listOrders() {
        return ordersGateway.listOrders();
    }
}
