package com.fiap.digidine.infrastructure.persistence;

import com.fiap.digidine.domain.entities.enums.Category;
import com.fiap.digidine.infrastructure.persistence.entities.mongodb.ProductEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductMongoDBRepository extends MongoRepository<ProductEntity, String> {

    List<ProductEntity> findByCategory(Category category);

    Optional<ProductEntity> findByProductNumber(long productNumber);

    @Query(value = "{}", sort = "{productNumber: -1}", fields = "{productNumber: 1}")
    ProductEntity findTopByProductByProductNumberDesc();

    void deleteByProductNumber(long productNumber);
}
