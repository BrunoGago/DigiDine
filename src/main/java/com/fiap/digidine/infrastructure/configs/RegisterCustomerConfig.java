package com.fiap.digidine.infrastructure.configs;

import com.fiap.digidine.applications.service.RegisterCustomerService;
import com.fiap.digidine.infrastructure.adapters.outbound.RegisterCustomerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RegisterCustomerConfig {

    @Bean
    public RegisterCustomerService registerCustomerService(RegisterCustomerAdapter registerCustomerAdapter)
    {
        return new RegisterCustomerService(registerCustomerAdapter);
    }
}
