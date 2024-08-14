package com.fiap.digidine.applications.adapters.inbound.rest;

import com.fiap.digidine.applications.dto.OrderDto;
import com.fiap.digidine.applications.ports.inbound.OrderServicePort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    private final OrderServicePort orderServicePort;

    public OrderController(OrderServicePort orderServicePort) {
        this.orderServicePort = orderServicePort;
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody OrderDto orderDto) {
        orderServicePort.createOrder(orderDto);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable UUID id, @RequestBody OrderDto orderDto) {
        orderServicePort.updateOrder(id, orderDto);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping
    public ResponseEntity<List<OrderDto>> list() {
        List<OrderDto> orders = orderServicePort.listOrders();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @PostMapping("/checkout/{id}")
    public ResponseEntity<Void> fakeCheckout(@PathVariable UUID id) {
        orderServicePort.fakeCheckout(id);
        return ResponseEntity.ok().build();
    }
}
