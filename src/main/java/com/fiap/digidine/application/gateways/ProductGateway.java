package com.fiap.digidine.application.gateways;

import com.fiap.digidine.domain.entities.Product;
import com.fiap.digidine.domain.entities.enums.Category;

import java.util.List;

public interface ProductGateway {

    void create(Product product);
    Product getById(String id);
    Product updateById(String id, Product request);
    void remove(String id);
    List<Product> findByCategory(Category category);
    List<Product> list();
}
