package com.fiap.digidine.application.usecases;

import com.fiap.digidine.application.gateways.PaymentGateway;
import com.fiap.digidine.domain.entities.Payment;

public class GetPaymentStatusUseCase {
    private final PaymentGateway paymentsGateway;

    public GetPaymentStatusUseCase(PaymentGateway paymentsGateway) {
        this.paymentsGateway = paymentsGateway;
    }

    public Payment getPaymentStatusByOrderNumber (long orderNumber) {
        return paymentsGateway.getStatusByOrderId(orderNumber);
    }
}