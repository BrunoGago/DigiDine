package com.fiap.digidine.infrastructure.adapters.outbound.repositories;

import com.fiap.digidine.domain.model.ProductModel;
import com.fiap.digidine.domain.model.enums.CategoryEnum;
import com.fiap.digidine.domain.ports.outbound.ProductRepositoryPort;
import com.fiap.digidine.infrastructure.adapters.outbound.repositories.entities.ProductEntity;
import com.fiap.digidine.infrastructure.adapters.outbound.repositories.jpa.ProductJpaRepository;
import com.fiap.digidine.infrastructure.adapters.outbound.repositories.mappers.ProductEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class ProductRepositoryImpl implements ProductRepositoryPort {

    @Autowired
    private ProductJpaRepository repository;

    @Autowired
    private ProductEntityMapper mapper;

    @Override
    public void create(ProductModel product) {
        ProductEntity entity = mapper.toEntity(product);
        repository.save(entity);
    }

    @Override
    public Optional<ProductModel> getById(UUID id) {
        return repository.findById(id).map(mapper::toModel);
    }

    @Override
    public void update(ProductModel product) {
        ProductEntity entity = mapper.toEntity(product);
        repository.save(entity);
    }

    @Override
    public void removeById(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<ProductModel> getByCategory(CategoryEnum category) {
        return repository.findByCategory(category).map(mapper::toModel);
    }
}
