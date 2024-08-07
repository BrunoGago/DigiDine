package com.fiap.digidine.applications.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.fiap.digidine.applications.ports.inbound.ListOrdersInputPort;
import com.fiap.digidine.applications.ports.outbound.ListOrdersOutputPort;
import com.fiap.digidine.domain.model.OrderModel;

@Service
public class ListOrderService implements ListOrdersInputPort {
    
    public ListOrdersOutputPort listOrdersOutputPort; 

    public ListOrderService(ListOrdersOutputPort listOrdersOutputPort){
        this.listOrdersOutputPort = listOrdersOutputPort;
    }

    @Override
    public OrderModel listOrders(UUID id) {
        return listOrdersOutputPort.listOrders(id);
    }
}
