package com.fiap.digidine.application.usecases;

import com.fiap.digidine.application.gateways.PaymentGateway;
import com.fiap.digidine.domain.entities.Payment;

public class GetPaymentStatusUseCase {
    private final PaymentGateway paymentsGateway;

    public GetPaymentStatusUseCase(PaymentGateway paymentsGateway) {
        this.paymentsGateway = paymentsGateway;
    }

    public Payment getPaymentStatus (String orderId) {
        return paymentsGateway.getStatus(orderId);
    }
}