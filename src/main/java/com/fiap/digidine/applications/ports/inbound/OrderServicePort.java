package com.fiap.digidine.applications.ports.inbound;

import com.fiap.digidine.applications.dto.OrderDto;

import java.util.List;
import java.util.UUID;

public interface OrderServicePort {
    void createOrder(OrderDto orderDto);
    void updateOrder(UUID id, OrderDto orderDto);
    List<OrderDto> listOrders();
    void fakeCheckout(UUID id);
}
