package com.fiap.digidine.infrastructure.controllers;

import com.fiap.digidine.application.gateways.PaymentGateway;
import com.fiap.digidine.application.usecases.GetPaymentStatusUseCase;
import com.fiap.digidine.domain.entities.Payment;
import com.fiap.digidine.infrastructure.controllers.dtos.PaymentResponse;
import com.fiap.digidine.infrastructure.controllers.mappers.PaymentDTOMapper;
import com.fiap.digidine.infrastructure.controllers.mappers.ProductDTOMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/payments")
public class PaymentController {

    private final GetPaymentStatusUseCase paymentStatusUseCase;
    private final PaymentDTOMapper paymentDTOMapper;

    public PaymentController(GetPaymentStatusUseCase paymentStatusUseCase, PaymentDTOMapper paymentDTOMapper){
        this.paymentStatusUseCase = paymentStatusUseCase;
        this.paymentDTOMapper = paymentDTOMapper;
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaymentResponse> getPaymentStatusByOrderId(@PathVariable String orderId) {
        try{
            Payment payment = paymentStatusUseCase.getPaymentStatus(orderId);
            return ResponseEntity.status(HttpStatus.OK).body(paymentDTOMapper.toResponse(payment));
        }catch (IllegalArgumentException illegalArgumentException){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
