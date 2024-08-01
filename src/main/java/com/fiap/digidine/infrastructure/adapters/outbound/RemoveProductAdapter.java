package com.fiap.digidine.infrastructure.adapters.outbound;

import com.fiap.digidine.applications.ports.outbound.RemoveProductOutputPort;
import com.fiap.digidine.infrastructure.adapters.outbound.repositories.ProductJpaRepository;
import com.fiap.digidine.infrastructure.adapters.outbound.repositories.entities.ProductEntity;
import com.fiap.digidine.infrastructure.adapters.outbound.repositories.mappers.ProductEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class RemoveProductAdapter implements RemoveProductOutputPort {

    @Autowired
    private ProductJpaRepository productJpaRepository;

    @Autowired
    private ProductEntityMapper productEntityMapper;

    @Override
    public void removeProduct(long id) {
        var productEntity = productEntityMapper.toProductEntity(id);
        productJpaRepository.deleteById(id);
    }
}
