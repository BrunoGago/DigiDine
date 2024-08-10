package com.fiap.digidine.infrastructure.adapters.outbound.repositories.mappers;

import com.fiap.digidine.domain.model.CustomerModel;
import com.fiap.digidine.infrastructure.adapters.inbound.controllers.mappers.CustomerMapper;
import com.fiap.digidine.infrastructure.adapters.outbound.repositories.entities.CustomerEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Component
public class CustomerEntityMapper {

    // Converte CustomerModel para CustomerEntity
    public static CustomerEntity toCustomerEntity(CustomerModel customerModel) {
        if (customerModel == null) {
            return null;
        }

        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setId(customerModel.getId());
        customerEntity.setCpf(customerModel.getCpf());
        customerEntity.setName(customerModel.getName());
        customerEntity.setEmail(customerModel.getEmail());

        return customerEntity;
    }

    // Converte CustomerEntity para CustomerModel
    public static CustomerModel toCustomerModel(CustomerEntity customerEntity) {
        if (customerEntity == null) {
            return null;
        }

        CustomerModel customerModel = new CustomerModel();
        customerModel.setId(customerEntity.getId());
        customerModel.setCpf(customerEntity.getCpf());
        customerModel.setName(customerEntity.getName());
        customerModel.setEmail(customerEntity.getEmail());

        return customerModel;
    }
}
