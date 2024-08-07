package com.fiap.digidine.infrastructure.adapters.outbound;

import com.fiap.digidine.applications.ports.outbound.EditProductOutputPort;
import com.fiap.digidine.infrastructure.adapters.inbound.controllers.dtos.ProductDto;
import com.fiap.digidine.infrastructure.adapters.outbound.repositories.ProductJpaRepository;
import com.fiap.digidine.infrastructure.adapters.outbound.repositories.entities.ProductEntity;
import com.fiap.digidine.infrastructure.adapters.outbound.repositories.mappers.ProductEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;
import java.util.UUID;

public class EditProductAdapter implements EditProductOutputPort {

    @Autowired
    private ProductJpaRepository productJpaRepository;

    @Autowired
    private ProductEntityMapper productEntityMapper;


    @Override
    public ProductModel editProduct(ProductDto productDto, UUID id) {

        Optional<ProductEntity> optionalProductEntity = productJpaRepository.findById(id);

        if(!optionalProductEntity.isPresent())
            throw new IllegalArgumentException("Produto não encontrado");

        var entity =  optionalProductEntity.get();

        entity.setName(productDto.getName());
        entity.setDescription(productDto.getDescription());
        entity.setPrice(productDto.getPrice());
        entity.setCategory(productDto.getCategory());

        return productEntityMapper.toProductModel(productJpaRepository.save(entity));


    }
}
