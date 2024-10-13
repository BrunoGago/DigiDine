package com.fiap.digidine.infrastructure.controllers;

import com.fiap.digidine.application.gateways.CustomerGateway;
import com.fiap.digidine.domain.entities.Customer;
import com.fiap.digidine.infrastructure.controllers.dtos.CustomerRequest;
import com.fiap.digidine.infrastructure.controllers.mappers.CustomerDTOMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {
    private final CustomerGateway customersGateway;
    private final CustomerDTOMapper customerDTOMapper;

    public CustomerController(CustomerGateway customersGateway, CustomerDTOMapper customerDTOMapper){
        this.customersGateway = customersGateway;
        this.customerDTOMapper = customerDTOMapper;
    }

    @PostMapping
    public ResponseEntity<Void> registerCustomer(@RequestBody CustomerRequest request){
        try{
            Customer customer = customersGateway.register(customerDTOMapper.toCustomer(request));
        }catch (IllegalArgumentException illegalArgumentException){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<Object> getCustomerByCpf(@PathVariable String cpf) {
        Customer customer;
        try{
            customer = customersGateway.getByCpf(cpf);
        }catch (IllegalArgumentException illegalArgumentException){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(illegalArgumentException.getMessage());
        }
        return ResponseEntity.status(HttpStatus.OK).body(customer);
    }
}
