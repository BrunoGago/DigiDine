package com.fiap.digidine.infrastructure.configs;

import com.fiap.digidine.applications.service.RemoveProductService;
import com.fiap.digidine.infrastructure.adapters.outbound.RemoveProductAdapter;
import org.springframework.context.annotation.Bean;

public class RemoveProductConfig {

    @Bean
    public RemoveProductService removeProductService(RemoveProductAdapter removeProductAdapter)
    {
        return new RemoveProductService(removeProductAdapter);
    }
}
