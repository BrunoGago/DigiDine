package com.fiap.digidine.application.controllers;

import com.fiap.digidine.application.gateways.CustomerGateway;
import com.fiap.digidine.domain.entities.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Value;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerGateway customerGateway;
    private final RestTemplate restTemplate;

    @Value("${aws.lambda.url}")
    private String lambdaUrl;

    public CustomerController(CustomerGateway customerGateway, RestTemplate restTemplate) {
        this.customerGateway = customerGateway;
        this.restTemplate = restTemplate;
    }

    @GetMapping("/authenticate")
    public ResponseEntity<Customer> authenticate(@RequestParam String cpf) {
        Customer customer = customerGateway.getByCpf(cpf);
        if (customer != null) {
            return ResponseEntity.ok(customer);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @GetMapping("/authenticateWithApiGateway")
    public ResponseEntity<String> authenticateWithApiGateway(@RequestParam String cpf) {
        String apiGatewayUrl = "https://your-api-id.execute-api.region.amazonaws.com/your-stage";
        String response = restTemplate.getForObject(apiGatewayUrl + "?cpf=" + cpf, String.class);
        if ("Authenticated".equals(response)) {
            return ResponseEntity.ok("Authenticated"); 
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Authentication Failed");
        }
    }
}
