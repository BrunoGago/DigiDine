package com.fiap.digidine.infrastructure.adapters.outbound.repositories;

import com.fiap.digidine.domain.model.CustomerModel;
import com.fiap.digidine.domain.ports.outbound.CustomerRepositoryPort;
import com.fiap.digidine.infrastructure.adapters.outbound.repositories.entities.CustomerEntity;
import com.fiap.digidine.infrastructure.adapters.outbound.repositories.jpa.CustomerJpaRepository;
import com.fiap.digidine.infrastructure.adapters.outbound.repositories.mappers.CustomerEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class CustomerRepositoryImpl implements CustomerRepositoryPort {

    @Autowired
    private CustomerJpaRepository repository;

    @Autowired
    private CustomerEntityMapper mapper;


    @Override
    public CustomerModel save(CustomerModel customerModel) {
        CustomerEntity entity = mapper.toEntity(customerModel);
        entity.setId(UUID.randomUUID());
        return mapper.toModel(repository.save(entity));
    }

    @Override
    public Optional<CustomerModel> findByCpf(String cpf) {
        return repository.findByCpf(cpf).map(mapper::toModel);
    }
}
