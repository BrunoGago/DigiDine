package com.fiap.digidine.infrastructure.controllers;

import com.fiap.digidine.application.gateways.OrderGateway;
import com.fiap.digidine.domain.entities.Order;
import com.fiap.digidine.infrastructure.controllers.dtos.OrderRequest;
import com.fiap.digidine.infrastructure.controllers.dtos.OrderResponse;
import com.fiap.digidine.infrastructure.controllers.mappers.OrderDTOMapper;
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

    public OrderController(OrderGateway orderGateway, OrderDTOMapper orderDTOMapper){
        this.orderGateway = orderGateway;
        this.orderDTOMapper = orderDTOMapper;
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody OrderRequest request) {
        try{
            orderGateway.createOrder(orderDTOMapper.toOrder(request));
        }catch (IllegalArgumentException illegalArgumentException){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable String id, @RequestBody OrderRequest request) {
        Order order;
        try{
            order = orderGateway.updateOrder(id, orderDTOMapper.toOrder(request));
        }catch (IllegalArgumentException illegalArgumentException){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(illegalArgumentException.getMessage());
        }
        return ResponseEntity.status(HttpStatus.OK).body(order);
    }

    @GetMapping
    public ResponseEntity<List<OrderResponse>> list() {
        List<Order> orders;
        try{
            orders = orderGateway.listOrders();
        }catch (IllegalArgumentException illegalArgumentException){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(orderDTOMapper.toResponses(orders));
    }

    @PostMapping("/checkout/{id}")
    public ResponseEntity<Void> fakeCheckout(@PathVariable UUID id) {
        return null;
    }

}
