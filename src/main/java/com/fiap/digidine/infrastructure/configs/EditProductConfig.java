package com.fiap.digidine.infrastructure.configs;

import com.fiap.digidine.applications.service.CreateProductService;
import com.fiap.digidine.applications.service.EditProductService;
import com.fiap.digidine.infrastructure.adapters.outbound.CreateProductAdapter;
import com.fiap.digidine.infrastructure.adapters.outbound.EditProductAdapter;
import org.springframework.context.annotation.Bean;

public class EditProductConfig {

    @Bean
    public EditProductService editProductService(EditProductAdapter editProductAdapter)
    {
        return new EditProductService(editProductAdapter);
    }
}
