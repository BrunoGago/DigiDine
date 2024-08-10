package com.fiap.digidine.infrastructure.adapters.inbound.controllers.mappers;

import com.fiap.digidine.domain.model.CustomerModel;
import com.fiap.digidine.infrastructure.adapters.inbound.controllers.dtos.CustomerDto;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    // Converte CustomerDto para CustomerModel
    public static CustomerModel toCustomerModel(CustomerDto customerDto) {
        if (customerDto == null) {
            return null;
        }

        CustomerModel customerModel = new CustomerModel();
        customerModel.setCpf(customerDto.getCpf());
        customerModel.setName(customerDto.getName());
        customerModel.setEmail(customerDto.getEmail());

        return customerModel;
    }

    // Converte CustomerModel para CustomerDto
    public static CustomerDto toCustomerDto(CustomerModel customerModel) {
        if (customerModel == null) {
            return null;
        }

        CustomerDto customerDto = new CustomerDto(customerModel.getName(), customerModel.getCpf(), customerModel.getEmail());

        return customerDto;
    }
}
