package com.fiap.digidine.infrastructure.adapters.outbound.repositories.mappers;

import com.fiap.digidine.domain.model.CustomerModel;
import com.fiap.digidine.domain.model.OrderModel;
import com.fiap.digidine.domain.model.ProductModel;
import com.fiap.digidine.infrastructure.adapters.outbound.repositories.entities.CustomerEntity;
import com.fiap.digidine.infrastructure.adapters.outbound.repositories.entities.OrderEntity;
import com.fiap.digidine.infrastructure.adapters.outbound.repositories.entities.OrderedItemEntity;
import com.fiap.digidine.infrastructure.adapters.outbound.repositories.entities.ProductEntity;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class OrderEntityMapper {

        public OrderModel toModel(OrderEntity entity) {
        if (entity == null) {
            return null;
        }

        OrderModel model = new OrderModel();
        model.setId(entity.getId());
        model.setCustomer(toCustomerModel(entity.getCustomer()));
        model.setProducts(toProductModels(entity.getItens()));
        model.setTotalAmount(calculateTotalAmount(entity.getItens()));

        return model;
    }

    public List<OrderModel> toModels(List<OrderEntity> entities) {
        if (entities == null || entities.isEmpty()) {
            return new ArrayList<>();
        }

        List<OrderModel> orderModels = new ArrayList<>();
        for(OrderEntity orderEntity : entities)
        {
            OrderModel orderModel = new OrderModel();
            orderModel.setId(orderEntity.getId());
            orderModel.setCustomer(toCustomerModel(orderEntity.getCustomer()));
            orderModel.setProducts(toProductModels(orderEntity.getItens()));
            orderModel.setTotalAmount(calculateTotalAmount(orderEntity.getItens()));
            orderModels.add(orderModel);
        }
        return orderModels;
    }

    public OrderEntity toEntity(OrderModel model) {
        if (model == null) {
            return null;
        }

        OrderEntity entity = new OrderEntity();
        entity.setId(model.getId());
        entity.setCustomer(toCustomerEntity(model.getCustomer()));
        entity.setItens(toOrderedItemEntities(model.getProducts()));

        return entity;
    }

    public OrderEntity toUpdatedEntity(UUID id, OrderModel model) {
        if (model == null) {
            return null;
        }

        OrderEntity entity = new OrderEntity();
        entity.setId(id);
        entity.setCustomer(toCustomerEntity(model.getCustomer()));
        entity.setItens(toOrderedItemEntities(model.getProducts()));

        return entity;
    }

    private CustomerModel toCustomerModel(CustomerEntity entity) {
        if (entity == null) {
            return null;
        }

        CustomerModel model = new CustomerModel();
        model.setId(entity.getId());
        model.setName(entity.getName());
        model.setEmail(entity.getEmail());

        return model;
    }

    private CustomerEntity toCustomerEntity(CustomerModel model) {
        if (model == null) {
            return null;
        }

        CustomerEntity entity = new CustomerEntity();
        entity.setId(model.getId());
        entity.setName(model.getName());
        entity.setEmail(model.getEmail());

        return entity;
    }

    private List<ProductModel> toProductModels(List<OrderedItemEntity> orderedItems) {
        return orderedItems.stream()
                .map(item -> {
                    ProductModel productModel = new ProductModel();
                    productModel.setId(item.getProduct().getId());
                    productModel.setName(item.getProduct().getName());
                    productModel.setPrice(item.getProduct().getPrice());
                    return productModel;
                })
                .collect(Collectors.toList());
    }

    private List<OrderedItemEntity> toOrderedItemEntities(List<ProductModel> products) {
        return products.stream()
                .map(productModel -> {
                    OrderedItemEntity itemEntity = new OrderedItemEntity();
                    itemEntity.setProduct(toProductEntity(productModel));
                    itemEntity.setQuantity(1); // Ajustar conforme a lógica de quantidade
                    return itemEntity;
                })
                .collect(Collectors.toList());
    }

    private ProductEntity toProductEntity(ProductModel model) {
        if (model == null) {
            return null;
        }

        ProductEntity entity = new ProductEntity();
        entity.setId(model.getId());
        entity.setName(model.getName());
        entity.setPrice(model.getPrice());

        return entity;
    }

    private double calculateTotalAmount(List<OrderedItemEntity> orderedItems) {
        return orderedItems.stream()
                .mapToDouble(item -> item.getProduct().getPrice() * item.getQuantity())
                .sum();
    }

}
