package com.fiap.digidine.applications.service;

import com.fiap.digidine.applications.dto.ProductDto;
import com.fiap.digidine.applications.mappers.ProductMapper;
import com.fiap.digidine.applications.ports.inbound.ProductServicePort;
import com.fiap.digidine.domain.model.ProductModel;
import com.fiap.digidine.domain.model.enums.CategoryEnum;
import com.fiap.digidine.domain.ports.outbound.ProductRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductServicePort {

    @Autowired
    private ProductRepositoryPort productRepositoryPort;

    @Autowired
    private ProductMapper productMapper;

    @Override
    public void create(ProductDto productDto) {
        productRepositoryPort.create(productMapper.toModel(productDto));
    }

    @Override
    public ProductDto get(UUID id) {
        return productMapper.toDto(productRepositoryPort.getById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with ID: " + id)));
    }

    @Override
    public void update(UUID id, ProductDto productDto) {
        productRepositoryPort.update(productMapper.toModel(id, productDto));
    }

    @Override
    public void remove(UUID id) {
        productRepositoryPort.removeById(id);
    }

    @Override
    public List<ProductDto> findByCategory(CategoryEnum category) {
        return productMapper.toProductDtoList((List<ProductModel>) productRepositoryPort.getByCategory(category)
                .orElseThrow(() -> new RuntimeException("Product not found in category: " + category)));
    }

}


