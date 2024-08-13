package com.fiap.digidine.infrastructure.adapters.outbound.repositories.jpa;

import com.fiap.digidine.infrastructure.adapters.outbound.repositories.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ProductJpaRepository extends JpaRepository<ProductEntity, UUID> {
    Optional<ProductEntity> findById(UUID id);
}
