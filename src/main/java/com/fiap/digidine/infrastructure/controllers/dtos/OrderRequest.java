package com.fiap.digidine.infrastructure.controllers.dtos;

import com.fiap.digidine.domain.entities.Customer;
import com.fiap.digidine.domain.entities.Product;
import com.fiap.digidine.domain.entities.enums.OrderStatus;

import java.time.LocalDateTime;
import java.util.List;

public record OrderRequest(Long customerNumber, List<Long> productsNumber, double totalPrice, OrderStatus orderStatus, LocalDateTime createdAt) {
}
