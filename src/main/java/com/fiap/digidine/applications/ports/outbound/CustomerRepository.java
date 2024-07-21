package com.fiap.digidine.applications.ports.outbound;

import com.fiap.digidine.domain.model.CustomerModel;

import java.util.Optional;

/*
This interface serves as the output port in the application layer.
It mirrors the domain repository interface but is placed in the application layer to signify
that it is an entry point for the application logic to interact with the infrastructure layer.
This abstraction allows the application layer to be agnostic of the actual implementation details
of the data access logic.
 */
public interface CustomerRepository {

    CustomerModel save(CustomerModel customer);
    Optional<CustomerModel> findByCpf(String cpf);
}
