package com.fiap.digidine.infrastructure.controllers.mappers;

import com.fiap.digidine.domain.entities.Order;
import com.fiap.digidine.infrastructure.controllers.dtos.OrderRequest;
import com.fiap.digidine.infrastructure.controllers.dtos.OrderResponse;

import java.util.List;
import java.util.stream.Collectors;

public class OrderDTOMapper {

    public OrderResponse toResponse(Order order){
        return new OrderResponse(order.getOrderNumber(), order.getCustomer(), order.getProducts(), order.getTotalPrice(), order.getOrderStatus(), order.getCreatedAt());
    }

    public List<OrderResponse> toResponses(List<Order> orders) {
        return orders.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    public Order toOrder(OrderRequest request){
        return new Order(null, request.customerNumber(), request.productsNumber(), request.totalPrice(), request.orderStatus(), request.createdAt());
    }

}
