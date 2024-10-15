package com.fiap.digidine.infrastructure.configurations;

import com.fiap.digidine.application.gateways.CustomerGateway;
import com.fiap.digidine.application.usecases.GetCustomerByCpfUseCase;
import com.fiap.digidine.application.usecases.ListCustomersUseCase;
import com.fiap.digidine.application.usecases.RegisterCustomerUseCase;
import com.fiap.digidine.infrastructure.controllers.mappers.CustomerDTOMapper;
import com.fiap.digidine.infrastructure.gateways.CustomerRepositoryGateway;
import com.fiap.digidine.infrastructure.gateways.mappers.CustomerEntityMapper;
import com.fiap.digidine.infrastructure.persistence.CustomerMongoDBRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerConfig {

    @Bean
    GetCustomerByCpfUseCase getCustomerByCpfUseCase(CustomerGateway customerGateway) {
        return new GetCustomerByCpfUseCase(customerGateway);
    }

    @Bean
    ListCustomersUseCase listCustomersUseCase(CustomerGateway customerGateway) {
        return new ListCustomersUseCase(customerGateway);
    }

    @Bean
    RegisterCustomerUseCase registerCustomerUseCase(CustomerGateway customerGateway) {
        return new RegisterCustomerUseCase(customerGateway);
    }

    @Bean
    CustomerGateway customerGateway(CustomerMongoDBRepository customerMongoDBRepository, CustomerEntityMapper customerEntityMapper) {
        return new CustomerRepositoryGateway(customerMongoDBRepository, customerEntityMapper);
    }

    @Bean
    CustomerEntityMapper customerEntityMapper() {
        return new CustomerEntityMapper();
    }

    @Bean
    CustomerDTOMapper customerDTOMapper() {
        return new CustomerDTOMapper();
    }

}
