package com.fiap.digidine.infrastructure.adapters.inbound.controllers;


import com.fiap.digidine.applications.ports.inbound.CreateProductInputPort;
import com.fiap.digidine.applications.ports.inbound.EditProductInputPort;
import com.fiap.digidine.applications.ports.inbound.RemoveProductInputPort;
import com.fiap.digidine.infrastructure.adapters.inbound.controllers.dtos.ProductDto;
import com.fiap.digidine.infrastructure.adapters.inbound.controllers.mappers.ProductMapper;
import com.fiap.digidine.infrastructure.adapters.outbound.repositories.entities.ProductEntity;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    @Autowired
    private CreateProductInputPort createProductInputPort;

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private EditProductInputPort editProductInputPort;

    @Autowired
    private RemoveProductInputPort removeProductInputPort;

    @PostMapping
    public ResponseEntity<Void> createProduct(@Valid @RequestBody ProductDto productDto) {

        createProductInputPort.createProduct(productMapper.toProductDto(productDto));
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDto> editProduct(@RequestBody ProductDto productDto, @PathVariable UUID id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(productMapper
                        .toProductDto(editProductInputPort.editProduct(productDto,id)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeProduct(@PathVariable UUID id) {
        removeProductInputPort.removeProduct(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
