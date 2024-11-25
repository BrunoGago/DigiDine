package com.fiap.digidine.application.usecases;

import com.fiap.digidine.application.gateways.OrderGateway;
import com.fiap.digidine.domain.entities.enums.OrderStatus;

public class GetOrderStatusUseCase {

    private final OrderGateway ordersGateway;

    public GetOrderStatusUseCase(OrderGateway ordersGateway) {
        this.ordersGateway = ordersGateway;
    }

    public OrderStatus getOrderStatus(long orderNumber) {
        return ordersGateway.getOrderStatus(orderNumber);
    }
}
