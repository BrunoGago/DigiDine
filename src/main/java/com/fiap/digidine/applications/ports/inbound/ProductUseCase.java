package com.fiap.digidine.applications.ports.inbound;

import com.fiap.digidine.applications.core.domain.model.Product;
import com.fiap.digidine.applications.core.domain.model.enums.Category;

import java.util.List;

public interface ProductUseCase {

    Product createProduct(Product product);
    Product editProduct(Product product);
    void removeProduct(Long id);
    List<Product> findByCategory(Category category);
}
