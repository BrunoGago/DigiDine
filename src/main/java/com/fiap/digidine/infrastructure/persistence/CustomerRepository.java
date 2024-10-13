package com.fiap.digidine.infrastructure.persistence;

import com.fiap.digidine.infrastructure.persistence.entities.CustomerEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<CustomerEntity, String> {


}
