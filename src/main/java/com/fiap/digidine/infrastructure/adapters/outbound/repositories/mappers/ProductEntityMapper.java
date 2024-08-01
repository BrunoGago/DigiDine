package com.fiap.digidine.infrastructure.adapters.outbound.repositories.mappers;

import com.fiap.digidine.infrastructure.adapters.outbound.repositories.entities.ProductEntity;
import org.mapstruct.factory.Mappers;

public class ProductEntityMapper {

    public static final ProductEntityMapper INSTANCE = Mappers.getMapper(ProductEntityMapper.class);

    ProductEntity toProductEntity(ProductEntity productEntity);


}
