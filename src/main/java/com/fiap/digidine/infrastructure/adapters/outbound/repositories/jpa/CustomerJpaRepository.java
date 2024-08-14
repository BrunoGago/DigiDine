package com.fiap.digidine.infrastructure.adapters.outbound.repositories.jpa;

import com.fiap.digidine.infrastructure.adapters.outbound.repositories.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CustomerJpaRepository extends JpaRepository<CustomerEntity, UUID> {
    Optional<CustomerEntity> findByCpf(String cpf);
}
