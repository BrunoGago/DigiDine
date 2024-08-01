package com.fiap.digidine.infrastructure.adapters.outbound;

import com.fiap.digidine.applications.ports.outbound.CreateProductOutputPort;
import com.fiap.digidine.infrastructure.adapters.outbound.repositories.ProductJpaRepository;
import com.fiap.digidine.infrastructure.adapters.outbound.repositories.entities.ProductEntity;
import com.fiap.digidine.infrastructure.adapters.outbound.repositories.mappers.ProductEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

public class CreateProductAdapter implements CreateProductOutputPort {

    @Autowired
    private ProductJpaRepository productJpaRepository;

    @Autowired
    private ProductEntityMapper productEntityMapper;

    @Override
    public ProductEntity createProduct(ProductEntity product) {
        var productEntity = productEntityMapper.toProductEntity(product);
        productJpaRepository.save(productEntity);
    }


}
