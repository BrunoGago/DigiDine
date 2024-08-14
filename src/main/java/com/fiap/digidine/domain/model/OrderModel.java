package com.fiap.digidine.domain.model;

import com.fiap.digidine.domain.model.enums.OrderStatusEnum;

import java.util.List;
import java.util.UUID;

public class OrderModel {
    private UUID id;
    private CustomerModel customer;
    private List<ProductModel> products;
    private double totalAmount;

    private OrderStatusEnum orderStatus;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public CustomerModel getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerModel customer) {
        this.customer = customer;
    }

    public List<ProductModel> getProducts() {
        return products;
    }

    public void setProducts(List<ProductModel> products) {
        this.products = products;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public OrderStatusEnum getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatusEnum orderStatus) {
        this.orderStatus = orderStatus;
    }
}
