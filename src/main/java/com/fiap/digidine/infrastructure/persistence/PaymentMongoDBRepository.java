package com.fiap.digidine.infrastructure.persistence;

import com.fiap.digidine.infrastructure.persistence.entities.mongodb.PaymentEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PaymentMongoDBRepository extends MongoRepository<PaymentEntity, String> {

    PaymentEntity findByOrderId(String orderId);
}
