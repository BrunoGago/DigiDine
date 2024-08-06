package com.fiap.digidine.infrastructure.adapters.inbound.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fiap.digidine.applications.ports.inbound.CreateOrderInputPort;
import com.fiap.digidine.infrastructure.adapters.inbound.controllers.dtos.OrderDto;
import com.fiap.digidine.infrastructure.adapters.inbound.controllers.mappers.OrderMapper;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/ap1/v1/orders")
public class OrderController {
  
    @Autowired
    private CreateOrderInputPort createOrderInputPort;

    @Autowired
    private OrderMapper orderMapper;

    @PostMapping
    public ResponseEntity<Void> createOrder(@Valid @RequestBody OrderDto orderDto) {
        var order = orderMapper.toOrderModel(orderDto);
        createOrderInputPort.createOrder(order);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
