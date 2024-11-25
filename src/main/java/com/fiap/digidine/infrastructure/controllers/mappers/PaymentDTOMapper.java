package com.fiap.digidine.infrastructure.controllers.mappers;

import com.fiap.digidine.domain.entities.Payment;
import com.fiap.digidine.infrastructure.controllers.dtos.PaymentResponse;

public class PaymentDTOMapper {

    public PaymentResponse toResponse(Payment payment){
        return new PaymentResponse(payment.getPaymentNumber(), payment.getPaymentStatus());
    }
}
