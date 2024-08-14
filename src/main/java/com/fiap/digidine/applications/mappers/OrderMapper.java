package com.fiap.digidine.applications.mappers;

import com.fiap.digidine.applications.dto.OrderDto;
import com.fiap.digidine.domain.model.OrderModel;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {

    public OrderModel toModel(OrderDto dto) {
        if (dto == null) {
            return null;
        }

        OrderModel model = new OrderModel();
        model.setId(dto.getId());
        model.setCustomer;
        model.setTotalAmount(dto.getTotalAmount());

        return model;
    }

    public OrderDto toDto(OrderModel model) {
        if (model == null) {
            return null;
        }

        OrderDto dto = new OrderDto();
        dto.setId(model.getId());
        dto.setCustomerId(model.getCustomerId());
        dto.setProductIds(model.getProductIds());
        dto.setTotalAmount(model.getTotalAmount());

        return dto;
    }
}
