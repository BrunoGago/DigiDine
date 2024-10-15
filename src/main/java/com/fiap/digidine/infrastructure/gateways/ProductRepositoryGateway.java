package com.fiap.digidine.infrastructure.gateways;

import com.fiap.digidine.application.gateways.ProductGateway;
import com.fiap.digidine.domain.entities.Product;
import com.fiap.digidine.domain.entities.enums.Category;
import com.fiap.digidine.infrastructure.gateways.mappers.ProductEntityMapper;
import com.fiap.digidine.infrastructure.persistence.ProductMongoDBRepository;
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
    public void create(Product product) {
        productEntityMapper.toDomain(productRepository.save(productEntityMapper.toEntity(product)));
    }

    @Override
    public Product getById(String id) {
        ProductEntity productEntity = productRepository.findById(id).orElse(null);
        if (productEntity == null) {
            throw new IllegalArgumentException();
        }
        return productEntityMapper.toDomain(productEntity);
    }

    @Override
    public Product updateById(String id, Product product) {
        Optional<ProductEntity> optionalProductEntity = productRepository.findById(id);

        Product existingProduct = optionalProductEntity
                .map(productEntityMapper::toDomain)
                .orElseThrow(() -> new IllegalArgumentException("Produto não cadastrado anteriormente!"));

        // Atualizando os dados do produto
        existingProduct.setCategory(product.getCategory());
        existingProduct.setDescription(product.getDescription());
        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());

        // Salvando a entidade atualizada
        productRepository.save(productEntityMapper.toEntity(existingProduct));

        return existingProduct;
    }

    @Override
    public void remove(String id) {
        Optional<Product> existingOptionalProduct = productEntityMapper.toOptionalDomain(productRepository.findById(id));

        if(existingOptionalProduct == null)
        {
            throw new IllegalArgumentException("Produto não cadastrado anteriormente!");
        }

        productRepository.deleteById(id);
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
        if (productEntities == null) {
            throw new IllegalArgumentException();
        }
        return productEntityMapper.toDomains(productEntities);
    }
}
