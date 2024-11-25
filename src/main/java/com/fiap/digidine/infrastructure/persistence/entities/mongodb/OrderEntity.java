package com.fiap.digidine.infrastructure.persistence.entities.mongodb;

import com.fiap.digidine.domain.entities.enums.OrderStatus;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "orders") // Define a coleção do MongoDB
public class OrderEntity {

    @Id // Define o identificador do documento
    private String id;
    private long orderNumber;
    @DBRef // Indica que é uma referência a outro documento (CustomerEntity)
    private CustomerEntity customer;
    @DBRef // Indica que é uma lista de referências para documentos (ProductEntity)
    private List<ProductEntity> products;
    private double totalPrice;
    private OrderStatus status;
    private LocalDateTime createdAt;

    public OrderEntity() {
    }

    public OrderEntity(long orderNumber, CustomerEntity customer, List<ProductEntity> products, double totalPrice, OrderStatus status, LocalDateTime createdAt) {
        this.orderNumber = orderNumber;
        this.customer = customer;
        this.products = products;
        this.totalPrice = totalPrice;
        this.status = status;
        this.createdAt = createdAt;
    }

    public long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(long orderNumber) {
        this.orderNumber = orderNumber;
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

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
