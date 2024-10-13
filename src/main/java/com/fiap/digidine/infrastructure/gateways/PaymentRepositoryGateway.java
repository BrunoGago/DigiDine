package com.fiap.digidine.infrastructure.gateways;

import com.fiap.digidine.application.gateways.PaymentGateway;
import com.fiap.digidine.domain.entities.Payment;
import com.fiap.digidine.infrastructure.gateways.mappers.PaymentEntityMapper;
import com.fiap.digidine.infrastructure.persistence.PaymentRepository;
import com.fiap.digidine.infrastructure.persistence.entities.PaymentEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PaymentRepositoryGateway implements PaymentGateway {

    private final PaymentRepository paymentRepository;
    private final PaymentEntityMapper paymentEntityMapper;

    @Autowired
    public PaymentRepositoryGateway(PaymentRepository paymentRepository, PaymentEntityMapper paymentEntityMapper) {
        this.paymentRepository = paymentRepository;
        this.paymentEntityMapper = paymentEntityMapper;
    }


    @Override
    public Payment getStatus(String orderId) {
        return paymentEntityMapper.toDomain(paymentRepository.findByOrderId(orderId));
    }
}
