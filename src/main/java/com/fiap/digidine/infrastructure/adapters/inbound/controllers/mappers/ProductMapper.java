package com.fiap.digidine.infrastructure.adapters.inbound.controllers.mappers;

import com.fiap.digidine.infrastructure.adapters.inbound.controllers.dtos.ProductDto;
import com.fiap.digidine.infrastructure.adapters.outbound.repositories.entities.ProductEntity;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

public class ProductMapper {

    public static final ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    @Mapping(target = "id", ignore = true)
    ProductEntity toProductEntity(ProductDto productDto);

    ProductDto toProductDto(ProductEntity productEntity);

}
