package com.fiap.digidine.domain.repositories;

import com.fiap.digidine.domain.entities.Order;
import com.fiap.digidine.domain.entities.enums.OrderStatus;

import java.util.List;

public interface OrderRepository {
    Order save(Order order);
    Order findById(String id);
    List<Order> listOrders();
    void updateStatus(String id, OrderStatus status);
}
