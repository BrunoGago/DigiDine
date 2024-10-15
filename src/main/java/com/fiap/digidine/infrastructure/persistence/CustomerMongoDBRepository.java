package com.fiap.digidine.infrastructure.persistence;

import com.fiap.digidine.infrastructure.persistence.entities.mongodb.CustomerEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerMongoDBRepository extends MongoRepository<CustomerEntity, String> {


}
