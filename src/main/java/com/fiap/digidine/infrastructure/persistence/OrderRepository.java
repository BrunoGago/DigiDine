package com.fiap.digidine.infrastructure.persistence;

import com.fiap.digidine.infrastructure.persistence.entities.OrderEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<OrderEntity, String> {

}
