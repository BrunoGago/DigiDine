package com.fiap.digidine.infrastructure.adapters.outbound.repositories;

import com.fiap.digidine.domain.model.enums.CategoryEnum;
import com.fiap.digidine.infrastructure.adapters.outbound.repositories.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public class ProductJpaRepository extends JpaRepository<ProductEntity, UUID> {

     ProductEntity deleteById(long id);

     ProductEntity findById(long id);


}
