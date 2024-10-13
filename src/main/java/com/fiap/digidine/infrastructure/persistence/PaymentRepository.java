package com.fiap.digidine.infrastructure.persistence;

import com.fiap.digidine.infrastructure.persistence.entities.PaymentEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PaymentRepository extends MongoRepository<PaymentEntity, String> {

    PaymentEntity findByOrderId(String orderId);
}
