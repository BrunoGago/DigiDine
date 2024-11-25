package com.fiap.digidine.domain.entities;

import com.fiap.digidine.domain.entities.enums.OrderStatus;

import java.time.LocalDateTime;
import java.util.List;

public class Order {

    private Long orderNumber;
    private Long customerNumber;
    private List<Long> productsNumber;
    private double totalPrice;
    private OrderStatus orderStatus;
    private LocalDateTime createdAt;

    public Order(){

    }

    public Order(Long orderNumber, Long customerNumber, List<Long> productsNumber, double totalPrice, OrderStatus orderStatus, LocalDateTime createdAt) {
        this.orderNumber = orderNumber;
        this.customerNumber = customerNumber;
        this.productsNumber = productsNumber;
        this.totalPrice = totalPrice;
        this.orderStatus = orderStatus;
        this.createdAt = createdAt;
    }

    public Long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Long orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Long getCustomer() {
        return customerNumber;
    }

    public void setCustomer(Long customer) {
        this.customerNumber = customer;
    }

    public List<Long> getProducts() {
        return productsNumber;
    }

    public void setProducts(List<Long> products) {
        this.productsNumber = products;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

}