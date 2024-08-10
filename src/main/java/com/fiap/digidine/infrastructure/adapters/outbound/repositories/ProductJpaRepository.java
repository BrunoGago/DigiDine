package com.fiap.digidine.infrastructure.adapters.outbound.repositories;

import com.fiap.digidine.infrastructure.adapters.outbound.repositories.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProductJpaRepository extends JpaRepository<ProductEntity, UUID> {

     void deleteById(UUID id);

     Optional<ProductEntity> findById(UUID id);


}
