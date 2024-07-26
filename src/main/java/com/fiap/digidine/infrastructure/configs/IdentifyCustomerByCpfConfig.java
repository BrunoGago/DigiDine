package com.fiap.digidine.infrastructure.configs;

import com.fiap.digidine.applications.service.IdentifyCustomerByCpfService;
import com.fiap.digidine.infrastructure.adapters.outbound.IdentifyCustomerByCpfAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class IdentifyCustomerByCpfConfig {

    @Bean
    public IdentifyCustomerByCpfService identifyCustomerByCpfService(IdentifyCustomerByCpfAdapter identifyCustomerAdapter)
    {
        return new IdentifyCustomerByCpfService(identifyCustomerAdapter);
    }
}
