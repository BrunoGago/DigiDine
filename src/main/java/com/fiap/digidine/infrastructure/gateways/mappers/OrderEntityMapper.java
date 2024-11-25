package com.fiap.digidine.infrastructure.gateways.mappers;

import com.fiap.digidine.domain.entities.Order;
import com.fiap.digidine.infrastructure.persistence.entities.mongodb.OrderEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OrderEntityMapper {

    private CustomerEntityMapper customerEntityMapper;

    private ProductEntityMapper productEntityMapper;

    public OrderEntityMapper(CustomerEntityMapper customerEntityMapper, ProductEntityMapper productEntityMapper){
        this.customerEntityMapper = customerEntityMapper;
        this.productEntityMapper = productEntityMapper;
    }

    public OrderEntity toEntity(Order order){

        return new OrderEntity(order.getOrderNumber(), order.getCustomer(), order.getProducts(), order.getTotalPrice(), order.getOrderStatus(), order.getCreatedAt());
    }

    public Order toDomain(OrderEntity entity){
        return new Order(entity.getOrderNumber(), entity.getCustomer(), entity.getProducts(), entity.getTotalPrice(), entity.getStatus(), entity.getCreatedAt());
    }

    public Optional<Order> toOptionalDomain(Optional<OrderEntity> optionalEntity) {
        return optionalEntity.map(this::toDomain);
    }

    public List<Order> toDomains(List<OrderEntity> entities){
        List<Order> orders = new ArrayList<>();

        for (OrderEntity entity : entities) {
            Order order = new Order(
                    entity.getOrderNumber(),
                    entity.getCustomer(),
                    entity.getProducts(),
                    entity.getTotalPrice(),
                    entity.getStatus(),
                    entity.getCreatedAt()
            );
            orders.add(order);
        }
        return orders;
    }
}
