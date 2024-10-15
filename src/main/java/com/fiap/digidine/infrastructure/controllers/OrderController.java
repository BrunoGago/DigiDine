package com.fiap.digidine.infrastructure.controllers;

import com.fiap.digidine.application.gateways.OrderGateway;
import com.fiap.digidine.domain.entities.Customer;
import com.fiap.digidine.domain.entities.Order;
import com.fiap.digidine.domain.entities.Product;
import com.fiap.digidine.infrastructure.controllers.dtos.CustomerRequest;
import com.fiap.digidine.infrastructure.controllers.dtos.OrderRequest;
import com.fiap.digidine.infrastructure.controllers.dtos.OrderResponse;
import com.fiap.digidine.infrastructure.controllers.dtos.ProductRequest;
import com.fiap.digidine.infrastructure.controllers.mappers.CustomerDTOMapper;
import com.fiap.digidine.infrastructure.controllers.mappers.OrderDTOMapper;
import com.fiap.digidine.infrastructure.controllers.mappers.ProductDTOMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    private final OrderGateway orderGateway;
    private final OrderDTOMapper orderDTOMapper;
    private final ProductDTOMapper productDTOMapper;

    private final CustomerDTOMapper customerDTOMapper;

    public OrderController(OrderGateway orderGateway, OrderDTOMapper orderDTOMapper, ProductDTOMapper productDTOMapper, CustomerDTOMapper customerDTOMapper){
        this.orderGateway = orderGateway;
        this.orderDTOMapper = orderDTOMapper;
        this.productDTOMapper = productDTOMapper;
        this.customerDTOMapper = customerDTOMapper;
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody OrderRequest request) {
        try{
            orderGateway.createOrder(orderDTOMapper.toOrder(request));
            return ResponseEntity.status(HttpStatus.OK).build();
        }catch (IllegalArgumentException illegalArgumentException){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable String id, @RequestBody OrderRequest request) {
        try{
            Order order = orderGateway.updateOrder(id, orderDTOMapper.toOrder(request));
            return ResponseEntity.status(HttpStatus.OK).body(order);
        }catch (IllegalArgumentException illegalArgumentException){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(illegalArgumentException.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<OrderResponse>> list() {
        try{
            List<Order> orders = orderGateway.listOrders();
            return ResponseEntity.ok(orderDTOMapper.toResponses(orders));
        }catch (IllegalArgumentException illegalArgumentException){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PostMapping("/checkout")
    public ResponseEntity<String> checkoutOrder(@RequestBody List<ProductRequest> products, @RequestBody CustomerRequest customerRequest) {
        String orderId = orderGateway.checkoutOrder(productDTOMapper.toProducts(products), customerDTOMapper.toCustomer(customerRequest));
        return ResponseEntity.ok(orderId);
    }

}
