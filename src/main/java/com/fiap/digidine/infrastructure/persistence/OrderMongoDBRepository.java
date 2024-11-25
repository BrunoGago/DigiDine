package com.fiap.digidine.infrastructure.persistence;

import com.fiap.digidine.domain.entities.Order;
import com.fiap.digidine.infrastructure.persistence.entities.mongodb.OrderEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface OrderMongoDBRepository extends MongoRepository<OrderEntity, String> {

    List<OrderEntity> findByStatusNotOrderByStatusAscCreatedAtAsc(String status);

    OrderEntity findFirstByOrderByOrderNumberDesc();

    OrderEntity findByOrderNumber(long orderNumber);
}
