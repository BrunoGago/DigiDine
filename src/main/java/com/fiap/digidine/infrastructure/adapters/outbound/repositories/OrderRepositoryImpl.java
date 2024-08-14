package com.fiap.digidine.infrastructure.adapters.outbound.repositories;

import com.fiap.digidine.domain.model.OrderModel;
import com.fiap.digidine.domain.ports.outbound.OrderRepositoryPort;
import com.fiap.digidine.infrastructure.adapters.outbound.repositories.entities.OrderEntity;
import com.fiap.digidine.infrastructure.adapters.outbound.repositories.jpa.OrderJpaRepository;
import com.fiap.digidine.infrastructure.adapters.outbound.repositories.mappers.OrderEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class OrderRepositoryImpl implements OrderRepositoryPort {

    @Autowired
    private OrderJpaRepository repository;

    @Autowired
    private OrderEntityMapper mapper;

    @Override
    public void create(OrderModel orderModel) {
        OrderEntity entity = mapper.toEntity(orderModel);
        repository.save(entity);
    }
    @Override
    public void update(UUID id, OrderModel orderModel) {
        OrderEntity entity = mapper.toUpdatedEntity(id, orderModel);
        repository.save(entity);
    }

    @Override
    public List<OrderModel> findAll() {
        return mapper.toModels(repository.findAll());
    }

    @Override
    public Optional<OrderModel> findById(UUID id) {
        return repository.findById(id).map(mapper::toModel);
    }
}
