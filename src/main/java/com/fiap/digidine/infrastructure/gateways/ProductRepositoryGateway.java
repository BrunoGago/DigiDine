package com.fiap.digidine.infrastructure.gateways;

import com.fiap.digidine.application.gateways.ProductGateway;
import com.fiap.digidine.domain.entities.Product;
import com.fiap.digidine.domain.entities.enums.Category;
import com.fiap.digidine.infrastructure.gateways.mappers.ProductEntityMapper;
import com.fiap.digidine.infrastructure.persistence.ProductMongoDBRepository;
import com.fiap.digidine.infrastructure.persistence.entities.mongodb.CustomerEntity;
import com.fiap.digidine.infrastructure.persistence.entities.mongodb.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ProductRepositoryGateway implements ProductGateway {
    private final ProductMongoDBRepository productRepository;
    private final ProductEntityMapper productEntityMapper;

    public ProductRepositoryGateway(ProductMongoDBRepository productRepository, ProductEntityMapper productEntityMapper) {
        this.productRepository = productRepository;
        this.productEntityMapper = productEntityMapper;
    }

    @Override
    public String create(Product product) {
        ProductEntity lastProduct= productRepository.findTopByProductByProductNumberDesc();
        long nextProductNumber = (lastProduct != null ? lastProduct.getProductNumber() : 0) + 1;

        product.setProductNumber(nextProductNumber);

        ProductEntity productEntity = productEntityMapper.toEntity(product);

        productRepository.save(productEntity);

        return productEntity.getId();
    }

    @Override
    public Product getByProductNumber(long productNumber) {
        Optional<ProductEntity> optionalProductEntity = productRepository.findByProductNumber(productNumber);

        if(optionalProductEntity.isEmpty())
        {
            throw new IllegalArgumentException("Produto não cadastrado anteriormente!");
        }

        return productEntityMapper.toDomain(optionalProductEntity.get());
    }

    @Override
    public Product updateByProductNumber(long productNumber, Product product) {
        // Faça uso da productRepository para buscar o produto pelo id
        Optional<ProductEntity> optionalProductEntity = productRepository.findByProductNumber(productNumber);

        // Verificando se o produto existe
        if(optionalProductEntity.isEmpty())
        {
            throw new IllegalArgumentException("Produto não cadastrado anteriormente!");
        }

        // Atualizando os dados do produto
        ProductEntity productEntity = optionalProductEntity.get();
        productEntity.setProductNumber(product.getProductNumber());
        productEntity.setCategory(product.getCategory());
        productEntity.setDescription(product.getDescription());
        productEntity.setName(product.getName());
        productEntity.setPrice(product.getPrice());

        // Salvando a entidade atualizada
        productRepository.save(productEntity);

        return productEntityMapper.toDomain(productEntity);
    }

    @Override
    public void removeByProductNumber(long productNumber) {
        // Faça uso da productRepository para buscar o produto pelo id
        Optional<ProductEntity> optionalProductEntity = productRepository.findByProductNumber(productNumber);

        // Verificando se o produto existe
        if(optionalProductEntity.isEmpty())
        {
            throw new IllegalArgumentException("Produto não cadastrado anteriormente!");
        }

        productRepository.deleteByProductNumber(productNumber);
    }

    @Override
    public List<Product> findByCategory(Category category) {
        List<ProductEntity> productEntities = productRepository.findByCategory(category);
        if (productEntities == null) {
            throw new IllegalArgumentException();
        }
        return productEntityMapper.toDomains(productEntities);
    }

    @Override
    public List<Product> list() {
        List<ProductEntity> productEntities = productRepository.findAll();

        // Verificando se há produtos cadastrados
        if(productEntities.isEmpty())
        {
            throw new IllegalArgumentException("Produto não cadastrado anteriormente!");
        }

        return productEntityMapper.toDomains(productEntities);
    }
}
