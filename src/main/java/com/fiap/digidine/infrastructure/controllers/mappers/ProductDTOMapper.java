package com.fiap.digidine.infrastructure.controllers.mappers;

import com.fiap.digidine.domain.entities.Product;
import com.fiap.digidine.infrastructure.controllers.dtos.ProductRequest;
import com.fiap.digidine.infrastructure.controllers.dtos.ProductResponse;

import java.util.List;
import java.util.stream.Collectors;

public class ProductDTOMapper {

    ProductResponse toResponse(Product product){
        return new ProductResponse(product.getName(), product.getDescription(), product.getPrice(), product.getCategory());
    }

    public List<ProductResponse> toResponses(List<Product> products) {
        return products.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    public Product toProduct(ProductRequest request){
        return new Product(request.name(), request.description(), request.price(), request.category());
    }
}
