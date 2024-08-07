package com.fiap.digidine.infrastructure.adapters.outbound.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fiap.digidine.infrastructure.adapters.outbound.repositories.entities.OrderEntity;

@Repository
public interface OrderJpaRepository extends JpaRepository<OrderEntity, UUID> {
    OrderEntity listById(UUID id);
}
