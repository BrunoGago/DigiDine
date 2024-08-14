package com.fiap.digidine.applications.mappers;

import com.fiap.digidine.applications.dto.ProductDto;
import com.fiap.digidine.domain.model.ProductModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class ProductMapper {

    public ProductModel toModel(ProductDto dto) {
        return toModel(null, dto);
    }

    // Mapeia um CustomerDto para um CustomerModel
    public ProductModel toModel(UUID id, ProductDto dto) {
        if (dto == null) {
            return null;
        }

        ProductModel model = new ProductModel();

        if (id != null) {
            model.setId(id);
        }

        model.setName(dto.getName());
        model.setCategory(dto.getCategory());
        model.setDescription(dto.getDescription());
        model.setPrice(dto.getPrice());

        return model;
    }

    // Mapeia um CustomerModel para um CustomerDto
    public ProductDto toDto(ProductModel model) {
        if (model == null) {
            return null;
        }

        ProductDto dto = new ProductDto();
        dto.setCategory(model.getCategory());
        dto.setDescription(model.getDescription());
        dto.setName(model.getName());
        dto.setPrice(model.getPrice());

        return dto;
    }

    public List<ProductDto> toDtos(List<ProductModel> models) {
        if (models == null) {
            return null;
        }
        List<ProductDto> dtos = new ArrayList<>();

        for (ProductModel model : models)
        {
            ProductDto dto = new ProductDto();
            dto.setCategory(model.getCategory());
            dto.setDescription(model.getDescription());
            dto.setName(model.getName());
            dto.setPrice(model.getPrice());
            dtos.add(dto);
        }
        return dtos;
    }
}
