package com.fiap.digidine.infrastructure.gateways.mappers;

import com.fiap.digidine.domain.entities.Payment;
import com.fiap.digidine.infrastructure.persistence.entities.mongodb.PaymentEntity;

public class PaymentEntityMapper {

    public Payment toDomain(PaymentEntity entity){
        return new Payment(
                entity.getPaymentNumber(),
                entity.getPaymentStatus(),
                entity.getMethod()
        );
    }

}
