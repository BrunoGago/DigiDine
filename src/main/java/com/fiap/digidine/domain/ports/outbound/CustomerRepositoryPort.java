package com.fiap.digidine.domain.ports.outbound;

import com.fiap.digidine.domain.model.CustomerModel;

import java.util.Optional;
import java.util.UUID;

public interface CustomerRepositoryPort {
    CustomerModel save(CustomerModel customerModel);
    Optional<CustomerModel> findByCpf(String cpf);
    CustomerModel getById(UUID id);
}
