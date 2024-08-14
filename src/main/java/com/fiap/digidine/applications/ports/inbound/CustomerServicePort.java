package com.fiap.digidine.applications.ports.inbound;


import com.fiap.digidine.applications.dto.CustomerDto;

public interface  CustomerServicePort {

    void registerCustomer(CustomerDto customerDto);
    CustomerDto getCustomerByCpf(String cpf);
}
