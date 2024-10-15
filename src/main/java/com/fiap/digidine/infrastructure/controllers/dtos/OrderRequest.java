package com.fiap.digidine.infrastructure.controllers.dtos;

import com.fiap.digidine.domain.entities.Customer;
import com.fiap.digidine.domain.entities.Product;
import com.fiap.digidine.domain.entities.enums.OrderStatus;

import java.time.LocalDateTime;
import java.util.List;

public record OrderRequest(String orderNumber, Customer customer, List<Product> products, double totalPrice, OrderStatus orderStatus, LocalDateTime createdAt) {
}
