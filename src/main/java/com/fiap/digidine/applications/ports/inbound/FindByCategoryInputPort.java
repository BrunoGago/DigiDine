package com.fiap.digidine.applications.ports.inbound;

import com.fiap.digidine.domain.model.ProductModel;
import com.fiap.digidine.domain.model.enums.CategoryEnum;

import java.util.List;

public interface FindByCategoryInputPort {

    List<ProductModel> findByCategory(CategoryEnum category);
}
