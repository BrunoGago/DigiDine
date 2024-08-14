package com.fiap.digidine.infrastructure.adapters.outbound.repositories.jpa;

import com.fiap.digidine.infrastructure.adapters.outbound.repositories.entities.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OrderJpaRepository extends JpaRepository<OrderEntity, UUID> {

}