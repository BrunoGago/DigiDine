package com.fiap.digidine.applications.ports.outbound;

import com.fiap.digidine.domain.model.ProductModel;
import com.fiap.digidine.domain.model.enums.CategoryEnum;

import java.util.List;

public interface FindByCategoryOutputPort {

    List<ProductModel> findByCategory(CategoryEnum category);
}