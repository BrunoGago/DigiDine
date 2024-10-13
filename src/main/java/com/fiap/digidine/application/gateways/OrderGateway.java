package com.fiap.digidine.application.gateways;

import com.fiap.digidine.domain.entities.Order;
import com.fiap.digidine.domain.entities.enums.OrderStatus;

import java.util.List;

public interface OrderGateway {

    void createOrder(Order order);
    Order updateOrderStatus(String id, OrderStatus status);
    Order updateOrder(String id, Order order);
    List<Order> listOrders();
    void checkoutOrder(Order order);
}
