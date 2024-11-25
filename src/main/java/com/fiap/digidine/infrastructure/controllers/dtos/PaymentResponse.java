package com.fiap.digidine.infrastructure.controllers.dtos;

import com.fiap.digidine.domain.entities.enums.PaymentMethod;
import com.fiap.digidine.domain.entities.enums.PaymentStatus;

public record PaymentResponse(long paymentNumber, PaymentStatus paymentStatus) {
}
