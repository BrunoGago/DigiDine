package com.fiap.digidine.infrastructure.configurations;

import com.fiap.digidine.application.gateways.OrderGateway;
import com.fiap.digidine.application.usecases.*;
import com.fiap.digidine.infrastructure.controllers.mappers.OrderDTOMapper;
import com.fiap.digidine.infrastructure.gateways.OrderRepositoryGateway;
import com.fiap.digidine.infrastructure.gateways.mappers.CustomerEntityMapper;
import com.fiap.digidine.infrastructure.gateways.mappers.OrderEntityMapper;
import com.fiap.digidine.infrastructure.gateways.mappers.ProductEntityMapper;
import com.fiap.digidine.infrastructure.persistence.OrderMongoDBRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderConfig {

    @Bean
    CalculateProductsPriceUseCase calculateProductsPriceUseCase(OrderGateway orderGateway) {
        return new CalculateProductsPriceUseCase(orderGateway);
    }

    @Bean
    CheckoutOrderUseCase checkoutOrderUseCase(OrderGateway orderGateway) {
        return new CheckoutOrderUseCase(orderGateway);
    }

    @Bean
    CreateOrderUserCase createOrderUserCase(OrderGateway orderGateway) {
        return new CreateOrderUserCase(orderGateway);
    }

    @Bean
    GetOrderStatusUseCase getOrderStatusUseCase(OrderGateway orderGateway) {
        return new GetOrderStatusUseCase(orderGateway);
    }

    @Bean
    ListOrdersUseCase listOrdersUseCase(OrderGateway orderGateway) {
        return new ListOrdersUseCase(orderGateway);
    }

    @Bean
    UpdateOrderStatusUseCase updateOrderStatusUseCase(OrderGateway orderGateway) {
        return new UpdateOrderStatusUseCase(orderGateway);
    }

    @Bean
    UpdateOrderUseCase updateOrderUseCase(OrderGateway orderGateway) {
        return new UpdateOrderUseCase(orderGateway);
    }

    @Bean
    OrderGateway orderGateway(OrderMongoDBRepository orderMongoDBRepository, OrderEntityMapper orderEntityMapper) {
        return new OrderRepositoryGateway(orderMongoDBRepository, orderEntityMapper);
    }

    @Bean
    OrderEntityMapper orderEntityMapper(CustomerEntityMapper customerEntityMapper, ProductEntityMapper productEntityMapper) {
        return new OrderEntityMapper(customerEntityMapper, productEntityMapper);
    }

    @Bean
    OrderDTOMapper orderDTOMapper() {
        return new OrderDTOMapper();
    }

}
