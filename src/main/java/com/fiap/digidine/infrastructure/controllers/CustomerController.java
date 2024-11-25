package com.fiap.digidine.infrastructure.controllers;

import com.fiap.digidine.application.gateways.CustomerGateway;
import com.fiap.digidine.domain.entities.Customer;
import com.fiap.digidine.infrastructure.controllers.dtos.CustomerRequest;
import com.fiap.digidine.infrastructure.controllers.mappers.CustomerDTOMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
            customersGateway.register(customerDTOMapper.toCustomer(request));
            return ResponseEntity.status(HttpStatus.OK).build();
        }catch (IllegalArgumentException illegalArgumentException){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<Object> getCustomerByCpf(@PathVariable String cpf) {
        try{
            Customer customer = customersGateway.getByCpf(cpf);
            return ResponseEntity.status(HttpStatus.OK).body(customer);
        }catch (IllegalArgumentException illegalArgumentException){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(illegalArgumentException.getMessage());
        }
    }

    @GetMapping()
    public ResponseEntity<Object> listCustomers() {
        try{
            List<Customer> customers = customersGateway.list();
            return ResponseEntity.status(HttpStatus.OK).body(customers);
        }catch (IllegalArgumentException illegalArgumentException){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(illegalArgumentException.getMessage());
        }
    }
}
