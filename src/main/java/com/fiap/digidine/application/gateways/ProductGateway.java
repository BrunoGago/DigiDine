package com.fiap.digidine.application.gateways;

import com.fiap.digidine.domain.entities.Product;
import com.fiap.digidine.domain.entities.enums.Category;

import java.util.List;

public interface ProductGateway {

    String create(Product product);
    Product getByProductNumber(long productNumber);
    Product updateByProductNumber(long productNumber, Product request);
    void removeByProductNumber(long ProductNumber);
    List<Product> findByCategory(Category category);
    List<Product> list();
}
