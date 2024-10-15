package com.fiap.digidine.application.gateways;

import com.fiap.digidine.domain.entities.Customer;
import com.fiap.digidine.domain.entities.Order;
import com.fiap.digidine.domain.entities.Product;
import com.fiap.digidine.domain.entities.enums.OrderStatus;

import java.util.List;

public interface OrderGateway {

    void createOrder(Order order);
    Order updateOrderStatus(String id, OrderStatus status);
    Order updateOrder(String orderNumber, Order order);
    List<Order> listOrders();
    String checkoutOrder(List<Product> products, Customer customer);

    Double calculatePrice(List<Product> products);

    OrderStatus getOrderStatus(String orderNumber);
}
