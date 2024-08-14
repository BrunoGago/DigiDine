package com.fiap.digidine.applications.mappers;

import com.fiap.digidine.applications.dto.CustomerDto;
import com.fiap.digidine.domain.model.CustomerModel;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    // Mapeia um CustomerDto para um CustomerModel
    public CustomerModel toModel(CustomerDto dto) {
        if (dto == null) {
            return null;
        }

        CustomerModel model = new CustomerModel();
        model.setCpf(dto.getCpf());
        model.setName(dto.getName());
        model.setEmail(dto.getEmail());

        return model;
    }

    // Mapeia um CustomerModel para um CustomerDto
    public CustomerDto toDto(CustomerModel model) {
        if (model == null) {
            return null;
        }

        CustomerDto dto = new CustomerDto(model.getCpf(), model.getName(), model.getEmail());

        return dto;
    }
}
