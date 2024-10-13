package com.fiap.digidine.infrastructure.persistence;

import com.fiap.digidine.domain.entities.enums.Category;
import com.fiap.digidine.infrastructure.persistence.entities.ProductEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProductRepository extends MongoRepository<ProductEntity, String> {

    List<ProductEntity> findByCategory(Category category);
}
