package com.fiap.digidine.infrastructure.configs;

import com.fiap.digidine.applications.service.CreateProductService;
import com.fiap.digidine.infrastructure.adapters.outbound.CreateProductAdapter;
import org.springframework.context.annotation.Bean;

public class CreateProductConfig {

    @Bean
    public CreateProductService createProductService(CreateProductAdapter createProductAdapter)
    {
        return new CreateProductService(createProductAdapter);
    }
}
