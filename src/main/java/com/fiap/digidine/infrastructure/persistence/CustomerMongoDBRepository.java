package com.fiap.digidine.infrastructure.persistence;

import com.fiap.digidine.domain.entities.Customer;
import com.fiap.digidine.infrastructure.persistence.entities.mongodb.CustomerEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface CustomerMongoDBRepository extends MongoRepository<CustomerEntity, String> {

    CustomerEntity findByCpf(String cpf);

    CustomerEntity findFirstByOrderByCustomerNumberDesc();

}
