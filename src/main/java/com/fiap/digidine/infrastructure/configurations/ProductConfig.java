package com.fiap.digidine.infrastructure.configurations;

import com.fiap.digidine.application.gateways.ProductGateway;
import com.fiap.digidine.application.usecases.*;
import com.fiap.digidine.infrastructure.controllers.mappers.ProductDTOMapper;
import com.fiap.digidine.infrastructure.gateways.ProductRepositoryGateway;
import com.fiap.digidine.infrastructure.gateways.mappers.ProductEntityMapper;
import com.fiap.digidine.infrastructure.persistence.ProductMongoDBRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductConfig {

    @Bean
    CreateProductUseCase createProductUseCase(ProductGateway productGateway) {
        return new CreateProductUseCase(productGateway);
    }

    @Bean
    FindProductByCategoryUseCase findProductByCategoryUseCase(ProductGateway productGateway) {
        return new FindProductByCategoryUseCase(productGateway);
    }

    @Bean
    GetProductUseCase getProductUseCase(ProductGateway productGateway) {
        return new GetProductUseCase(productGateway);
    }

    @Bean
    ListProductsUseCase listProductsUseCase(ProductGateway productGateway) {
        return new ListProductsUseCase(productGateway);
    }

    @Bean
    RemoveProductUseCase removeProductUseCase(ProductGateway productGateway) {
        return new RemoveProductUseCase(productGateway);
    }

    @Bean
    UpdateProductUseCase updateProductUseCase(ProductGateway productGateway) {
        return new UpdateProductUseCase(productGateway);
    }

    @Bean
    ProductGateway productGateway(ProductMongoDBRepository productMongoDBRepository, ProductEntityMapper productEntityMapper) {
        return new ProductRepositoryGateway(productMongoDBRepository, productEntityMapper);
    }

    @Bean
    ProductEntityMapper productEntityMapper() {
        return new ProductEntityMapper();
    }

    @Bean
    ProductDTOMapper productDTOMapper() {
        return new ProductDTOMapper();
    }

}
