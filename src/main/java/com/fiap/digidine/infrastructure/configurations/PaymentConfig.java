package com.fiap.digidine.infrastructure.configurations;

import com.fiap.digidine.application.gateways.PaymentGateway;
import com.fiap.digidine.application.usecases.GetPaymentStatusUseCase;
import com.fiap.digidine.infrastructure.controllers.mappers.PaymentDTOMapper;
import com.fiap.digidine.infrastructure.gateways.PaymentRepositoryGateway;
import com.fiap.digidine.infrastructure.gateways.mappers.PaymentEntityMapper;
import com.fiap.digidine.infrastructure.persistence.PaymentMongoDBRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PaymentConfig {
    @Bean
    GetPaymentStatusUseCase getPaymentStatusUseCase(PaymentGateway paymentGateway) {
        return new GetPaymentStatusUseCase(paymentGateway);
    }

    @Bean
    PaymentGateway paymentGateway(PaymentMongoDBRepository paymentMongoDBRepository, PaymentEntityMapper paymentEntityMapper) {
        return new PaymentRepositoryGateway(paymentMongoDBRepository, paymentEntityMapper);
    }

    @Bean
    PaymentEntityMapper paymentEntityMapper() {
        return new PaymentEntityMapper();
    }

    @Bean
    PaymentDTOMapper paymentDTOMapper() {
        return new PaymentDTOMapper();
    }

}
