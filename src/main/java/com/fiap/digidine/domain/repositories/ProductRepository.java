package com.fiap.digidine.domain.repositories;

import com.fiap.digidine.domain.entities.Product;

import java.util.List;

public interface ProductRepository {
    Product save(Product product);
    Product findById(String id);
    List<Product> listProducts();
    void update(Product product);
    void delete(String id);
}
