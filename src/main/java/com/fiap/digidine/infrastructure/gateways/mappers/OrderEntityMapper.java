package com.fiap.digidine.infrastructure.gateways.mappers;

import com.fiap.digidine.domain.entities.Order;
import com.fiap.digidine.infrastructure.persistence.entities.OrderEntity;

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

        return new OrderEntity(customerEntityMapper.toEntity(order.getCustomer()), productEntityMapper.toEntities(order.getProducts()), order.getTotalPrice(), order.getOrderStatus());
    }

    public Order toDomain(OrderEntity entity){
        return new Order(customerEntityMapper.toDomain(entity.getCustomer()), productEntityMapper.toDomains(entity.getProducts()), entity.getTotalPrice(), entity.getOrderStatus());
    }

    public Optional<Order> toOptionalDomain(Optional<OrderEntity> optionalEntity) {
        return optionalEntity.map(this::toDomain);
    }

    public List<Order> toDomains(List<OrderEntity> entities){
        List<Order> orders = new ArrayList<>();

        for (OrderEntity entity : entities) {
            Order order = new Order(
                    customerEntityMapper.toDomain(entity.getCustomer()),
                    productEntityMapper.toDomains(entity.getProducts()),
                    entity.getTotalPrice(),
                    entity.getOrderStatus()
            );
            orders.add(order);
        }
        return orders;
    }
}
