package com.fiap.digidine.infrastructure.persistence.entities;

import com.fiap.digidine.domain.entities.enums.OrderStatus;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "orders") // Define a coleção do MongoDB
public class OrderEntity {

    @Id // Define o identificador do documento
    private String id;

    @DBRef // Indica que é uma referência a outro documento (CustomerEntity)
    private CustomerEntity customer;

    @DBRef // Indica que é uma lista de referências para documentos (ProductEntity)
    private List<ProductEntity> products;

    private double totalPrice;
    private OrderStatus orderStatus;

    public OrderEntity() {
    }

    public OrderEntity(CustomerEntity customer, List<ProductEntity> products, double totalPrice, OrderStatus orderStatus) {
        this.customer = customer;
        this.products = products;
        this.totalPrice = totalPrice;
        this.orderStatus = orderStatus;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public CustomerEntity getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerEntity customer) {
        this.customer = customer;
    }

    public List<ProductEntity> getProducts() {
        return products;
    }

    public void setProducts(List<ProductEntity> products) {
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
