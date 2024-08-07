package com.fiap.digidine.applications.service;

import org.springframework.stereotype.Service;

import com.fiap.digidine.applications.ports.inbound.CreateOrderInputPort;
import com.fiap.digidine.applications.ports.outbound.CreateOrderOutputPort;
import com.fiap.digidine.domain.model.OrderModel;

@Service
public class CreateOrderService implements CreateOrderInputPort {

    private CreateOrderOutputPort createOrderOutputPort;

    public CreateOrderService(CreateOrderOutputPort createOrderOutputPort) {
        this.createOrderOutputPort = createOrderOutputPort;
    }
    
    @Override
    public void createOrder(OrderModel order) {
        createOrderOutputPort.createOrder(order);
    }
}
