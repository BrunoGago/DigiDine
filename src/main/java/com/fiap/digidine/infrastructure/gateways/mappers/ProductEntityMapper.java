package com.fiap.digidine.infrastructure.gateways.mappers;

import com.fiap.digidine.domain.entities.Product;
import com.fiap.digidine.infrastructure.persistence.entities.mongodb.ProductEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductEntityMapper {

    public ProductEntity toEntity(Product product){
        return new ProductEntity(product.getName(), product.getDescription(), product.getPrice(), product.getCategory());
    }

    public List<ProductEntity> toEntities(List<Product> products){
        List<ProductEntity> productEntities = new ArrayList<>();

        for (Product product : products) {
            ProductEntity productEntity = new ProductEntity(
                    product.getName(),
                    product.getDescription(),
                    product.getPrice(),
                    product.getCategory()
            );
            productEntities.add(productEntity);
        }
        return productEntities;
    }

    public Product toDomain(ProductEntity entity){
        return new Product(entity.getName(), entity.getDescription(), entity.getPrice(), entity.getCategory());
    }

    public Optional<Product> toOptionalDomain(Optional<ProductEntity> optionalEntity) {
        return optionalEntity.map(this::toDomain);
    }

    public List<Product> toDomains(List<ProductEntity> entities){
        List<Product> products = new ArrayList<>();

        for (ProductEntity entity : entities) {
            Product product = new Product(
                    entity.getName(),
                    entity.getDescription(),
                    entity.getPrice(),
                    entity.getCategory()
            );
            products.add(product);
        }
        return products;
    }

}
