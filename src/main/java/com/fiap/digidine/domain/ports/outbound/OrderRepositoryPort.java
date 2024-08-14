package com.fiap.digidine.domain.ports.outbound;

import com.fiap.digidine.domain.model.OrderModel;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OrderRepositoryPort {
    void create(OrderModel orderModel);
    void update(UUID id, OrderModel orderModel);
    List<OrderModel> findAll();
    Optional<OrderModel> findById(UUID id);
}
