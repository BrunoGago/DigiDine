package com.fiap.digidine.infrastructure.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fiap.digidine.applications.service.ListOrderService;
import com.fiap.digidine.infrastructure.adapters.outbound.ListOrderByIdAdapter;

@Configuration
public class ListOrderByIdConfig {
    @Bean
    public ListOrderService listOrderByIdService (ListOrderByIdAdapter listOrderByIdAdapter)
    {
        return new ListOrderService(listOrderByIdAdapter);
    }
}
