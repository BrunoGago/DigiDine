package com.fiap.digidine.applications.adapters.inbound.rest;

import com.fiap.digidine.applications.dto.CustomerDto;
import com.fiap.digidine.applications.ports.inbound.CustomerServicePort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    private final CustomerServicePort customerServicePort;

    public CustomerController(CustomerServicePort customerServicePort) {
        this.customerServicePort = customerServicePort;
    }

    @PostMapping
    public ResponseEntity<Void> registerCustomer(@RequestBody CustomerDto customerDto) {
        customerServicePort.registerCustomer(customerDto);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<CustomerDto> getCustomerByCpf(@PathVariable String cpf) {
        CustomerDto customerDto = customerServicePort.getCustomerByCpf(cpf);
        if (customerDto != null) {
            return new ResponseEntity<>(customerDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
