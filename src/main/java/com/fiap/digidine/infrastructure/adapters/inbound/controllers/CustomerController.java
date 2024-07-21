package com.fiap.digidine.infrastructure.adapters.inbound.controllers;

import com.fiap.digidine.applications.core.domain.model.Customer;
import com.fiap.digidine.applications.ports.inbound.CustomerUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    private final CustomerUseCase customerUseCase;

    public CustomerController(CustomerUseCase customerUseCase) {
        this.customerUseCase = customerUseCase;
    }

    @PostMapping
    public Customer registerCustomer(@RequestBody Customer customer) {
        return customerUseCase.registerCustomer(customer);
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<Customer> identificarCliente(@PathVariable String cpf) {
        return customerUseCase.identifyCustomer(cpf)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
