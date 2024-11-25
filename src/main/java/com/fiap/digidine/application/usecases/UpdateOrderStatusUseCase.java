package com.fiap.digidine.application.usecases;


import com.fiap.digidine.application.gateways.OrderGateway;
import com.fiap.digidine.domain.entities.Order;
import com.fiap.digidine.domain.entities.enums.OrderStatus;

public class UpdateOrderStatusUseCase {
    private final OrderGateway ordersGateway;

    public UpdateOrderStatusUseCase(OrderGateway ordersGateway) {
        this.ordersGateway = ordersGateway;
    }

    public Order updateOrderStatusByOrderNumber(long orderNumber, OrderStatus orderStatus) {
        return ordersGateway.updateOrderStatusByOrderNumber(orderNumber, orderStatus);
    }
}