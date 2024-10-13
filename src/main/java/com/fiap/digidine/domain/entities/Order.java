package com.fiap.digidine.domain.entities;

import com.fiap.digidine.domain.entities.enums.OrderStatus;

import java.util.List;

public class Order {
    private Customer customer;
    private List<Product> products;
    private double totalPrice;
    private OrderStatus orderStatus;

    public Order(){

    }

    public Order(Customer customer, List<Product> products, double totalPrice, OrderStatus orderStatus) {
        this.customer = customer;
        this.products = products;
        this.totalPrice = totalPrice;
        this.orderStatus = orderStatus;
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
}