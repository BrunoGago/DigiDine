package com.fiap.digidine.infrastructure.adapters.outbound.repositories;

import com.fiap.digidine.infrastructure.adapters.outbound.repositories.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CustomerJpaRepository extends JpaRepository<CustomerEntity, UUID> {

    CustomerEntity findByCpf(String cpf);
}
