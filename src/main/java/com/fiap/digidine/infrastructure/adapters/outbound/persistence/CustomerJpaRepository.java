package com.fiap.digidine.infrastructure.adapters.outbound.persistence;

import com.fiap.digidine.applications.ports.outbound.CustomerRepository;
import com.fiap.digidine.domain.model.CustomerModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CustomerJpaRepository extends JpaRepository<CustomerModel, UUID>, CustomerRepository {

    @Override
    Optional<CustomerModel> findByCpf(String cpf);
}
