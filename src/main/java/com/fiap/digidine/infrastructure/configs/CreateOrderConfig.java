package com.fiap.digidine.infrastructure.configs;

import org.springframework.context.annotation.Bean;

import com.fiap.digidine.applications.service.CreateOrderService;
import com.fiap.digidine.infrastructure.adapters.outbound.CreateOrderAdapter;

public class CreateOrderConfig {
    
    @Bean
    public CreateOrderService createOrderService(CreateOrderAdapter createOrderAdapter) {
        return new CreateOrderService(createOrderAdapter);
    }
}
