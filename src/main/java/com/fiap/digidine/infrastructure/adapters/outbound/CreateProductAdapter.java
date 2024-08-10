package com.fiap.digidine.infrastructure.adapters.outbound;

import com.fiap.digidine.applications.ports.outbound.CreateProductOutputPort;
import com.fiap.digidine.domain.model.ProductModel;
import com.fiap.digidine.infrastructure.adapters.inbound.controllers.dtos.ProductDto;
import com.fiap.digidine.infrastructure.adapters.outbound.repositories.ProductJpaRepository;
import com.fiap.digidine.infrastructure.adapters.outbound.repositories.mappers.ProductEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;



public class CreateProductAdapter implements CreateProductOutputPort {

    @Autowired
    private ProductJpaRepository productJpaRepository;

    @Autowired
    private ProductEntityMapper productEntityMapper;

    @Override
    public ProductModel createProduct(ProductDto productDto) {
        var productEntity = productEntityMapper.toProductDto(productDto);
        productJpaRepository.save(productEntity);
    }


}
