package com.fiap.digidine.applications.mappers;

import com.fiap.digidine.applications.dto.OrderDto;
import com.fiap.digidine.domain.model.CustomerModel;
import com.fiap.digidine.domain.model.OrderModel;
import com.fiap.digidine.domain.model.ProductModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderMapper {

    public OrderModel toModel(OrderDto dto,CustomerModel customerModel, List<ProductModel> products ) {
        if (dto == null) {
            return null;
        }

        OrderModel model = new OrderModel();
        model.setId(dto.getId());
        model.setCustomer(customerModel);
        model.setTotalAmount(dto.getTotalAmount());
        model.setProducts(products);

        return model;
    }

    public OrderDto toDto(OrderModel model) {
        if (model == null) {
            return null;
        }

        OrderDto dto = new OrderDto();
        dto.setId(model.getId());
        dto.setCustomerId(model.getCustomer().getId());
        dto.setProductIds(model.getProducts().stream().map(ProductModel::getId).toList());
        dto.setTotalAmount(model.getTotalAmount());

        return dto;
    }
}
