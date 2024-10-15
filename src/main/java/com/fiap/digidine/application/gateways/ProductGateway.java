package com.fiap.digidine.application.gateways;

import com.fiap.digidine.domain.entities.Product;
import com.fiap.digidine.domain.entities.enums.Category;

import java.util.List;

public interface ProductGateway {

    String create(Product product);
    Product getById(String productId);
    Product updateById(String productId, Product request);
    void remove(String productId);
    List<Product> findByCategory(Category category);
    List<Product> list();
}
