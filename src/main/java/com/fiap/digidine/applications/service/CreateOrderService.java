package com.fiap.digidine.applications.service;

import com.fiap.digidine.applications.ports.inbound.CreateOrderInputPort;
import com.fiap.digidine.applications.ports.outbound.CreateOrderOutputPort;
import com.fiap.digidine.infrastructure.adapters.outbound.repositories.entities.OrderEntity;

public class CreateOrderService implements CreateOrderInputPort {

    private CreateOrderOutputPort createOrderOutputPort;

    public CreateOrderService(CreateOrderOutputPort createOrderOutputPort) {
        this.createOrderOutputPort = createOrderOutputPort;
    }
    
    @Override
    public OrderEntity createOrder(OrderEntity order) {
        return createOrderOutputPort.createOrder(order);
    }
}
