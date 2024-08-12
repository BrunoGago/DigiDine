package com.fiap.digidine.applications.adapters.inbound.rest;

import com.fiap.digidine.applications.dto.CustomerDto;
import com.fiap.digidine.applications.dto.ProductDto;
import com.fiap.digidine.applications.ports.inbound.CustomerServicePort;
import com.fiap.digidine.applications.ports.inbound.ProductServicePort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductServicePort productServicePort;

    public ProductController(ProductServicePort productServicePort) {
        this.productServicePort = productServicePort;
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody ProductDto productDto) {
        productServicePort.create(productDto);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
