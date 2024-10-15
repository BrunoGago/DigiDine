package com.fiap.digidine.domain.entities;

import com.fiap.digidine.domain.entities.enums.OrderStatus;

import java.time.LocalDateTime;
import java.util.List;

public class Order {

    private String orderNumber;
    private Customer customer;
    private List<Product> products;
    private double totalPrice;
    private OrderStatus orderStatus;
    private LocalDateTime createdAt;

    public Order(){

    }

    public Order(String orderNumber, Customer customer, List<Product> products, double totalPrice, OrderStatus orderStatus, LocalDateTime createdAt) {
        this.orderNumber = orderNumber;
        this.customer = customer;
        this.products = products;
        this.totalPrice = totalPrice;
        this.orderStatus = orderStatus;
        this.createdAt = createdAt;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
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