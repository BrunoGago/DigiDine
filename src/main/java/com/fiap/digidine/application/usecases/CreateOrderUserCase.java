package com.fiap.digidine.application.usecases;

import com.fiap.digidine.application.gateways.OrderGateway;
import com.fiap.digidine.domain.entities.Order;

public class CreateOrderUserCase {

    private final OrderGateway ordersGateway;

    public CreateOrderUserCase(OrderGateway ordersGateway) {
        this.ordersGateway = ordersGateway;
    }

    public void createOrder(Order order){
        ordersGateway.createOrder(order);
    }

}
