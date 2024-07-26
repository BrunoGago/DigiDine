package com.fiap.digidine.infrastructure.adapters.inbound.controllers;

import com.fiap.digidine.applications.ports.inbound.IdentifyCustomerInputPort;
import com.fiap.digidine.applications.ports.inbound.RegisterCustomerInputPort;
import com.fiap.digidine.infrastructure.adapters.inbound.controllers.dtos.CustomerDto;
import com.fiap.digidine.infrastructure.adapters.inbound.controllers.mappers.CustomerMapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @Autowired
    private RegisterCustomerInputPort registerCustomerInputPort;

    @Autowired
    private IdentifyCustomerInputPort identifyCustomerInputPort;

    @Autowired
    private CustomerMapper customerMapper;

    @PostMapping
    public ResponseEntity<Void> registerCustomer(@Valid @RequestBody CustomerDto customerDto) {
        var customer = customerMapper.toCustomerModel(customerDto);
        registerCustomerInputPort.registerCustomer(customer);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<CustomerDto> identificarCliente(@PathVariable String cpf) {
        var customer = identifyCustomerInputPort.identifyCustomer(cpf);
        var customerDto = customerMapper.toCustomerDto(customer);
        return ResponseEntity.status(HttpStatus.OK).body(customerDto);
    }

}
