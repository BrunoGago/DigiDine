package com.fiap.digidine.infrastructure.controllers;

import com.fiap.digidine.application.gateways.ProductGateway;
import com.fiap.digidine.domain.entities.Product;
import com.fiap.digidine.domain.entities.enums.Category;
import com.fiap.digidine.infrastructure.controllers.dtos.ProductRequest;
import com.fiap.digidine.infrastructure.controllers.dtos.ProductResponse;
import com.fiap.digidine.infrastructure.controllers.mappers.ProductDTOMapper;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductGateway productsGateway;
    private final ProductDTOMapper productDTOMapper;

    public ProductController(ProductGateway productsGateway, ProductDTOMapper productDTOMapper){
        this.productsGateway = productsGateway;
        this.productDTOMapper = productDTOMapper;
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody ProductRequest request) {
        try{
            productsGateway.create(productDTOMapper.toProduct(request));
            return ResponseEntity.status(HttpStatus.OK).build();
        }catch (IllegalArgumentException illegalArgumentException){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable String id) {
        try{
            Product product = productsGateway.getById(id);
            return ResponseEntity.status(HttpStatus.OK).body(product);
        }catch (IllegalArgumentException illegalArgumentException){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(illegalArgumentException.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable String id, @RequestBody ProductRequest request) {
        try{
            Product product = productsGateway.updateById(id, productDTOMapper.toProduct(request));
            return ResponseEntity.status(HttpStatus.OK).body(product);
        }catch (IllegalArgumentException illegalArgumentException){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(illegalArgumentException.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remove(@PathVariable String id) {
        try{
            productsGateway.remove(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        }catch (IllegalArgumentException illegalArgumentException){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/category")
    public ResponseEntity<List<ProductResponse>> listProductsByCategory(@RequestParam("category") Category category) {
        try{
            List<Product> products = productsGateway.findByCategory(category);
            return ResponseEntity.status(HttpStatus.OK).body(productDTOMapper.toResponses(products));
        }catch (IllegalArgumentException illegalArgumentException){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

}
