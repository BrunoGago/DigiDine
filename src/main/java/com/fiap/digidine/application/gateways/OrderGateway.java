package com.fiap.digidine.application.gateways;

import com.fiap.digidine.domain.entities.Customer;
import com.fiap.digidine.domain.entities.Order;
import com.fiap.digidine.domain.entities.Product;
import com.fiap.digidine.domain.entities.enums.OrderStatus;

import java.util.List;

public interface OrderGateway {

    Long createOrder(Order order);
    Order updateOrderStatusByOrderNumber(long orderNumber, OrderStatus status);
    Order updateOrderByOrderNumber(long orderNumber, Order order);
    List<Order> listOrders();
    Double calculatePrice(List<Long> products);
    OrderStatus getOrderStatus(long orderNumber);
}
