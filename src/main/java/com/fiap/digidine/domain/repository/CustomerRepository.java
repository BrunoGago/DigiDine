package com.fiap.digidine.domain.repository;

import com.fiap.digidine.domain.model.CustomerModel;

import java.util.Optional;


/*
This interface defines the contract for the repository operations related to the Customer entity.
It is part of the domain layer because it represents the business requirements for data access
without being tied to any specific implementation details.
 */
public interface CustomerRepository  {
    CustomerModel save(CustomerModel customer);
    Optional<CustomerModel> findByCpf(String cpf);
}
