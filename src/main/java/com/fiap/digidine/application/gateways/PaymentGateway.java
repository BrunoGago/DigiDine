package com.fiap.digidine.application.gateways;

import com.fiap.digidine.domain.entities.Payment;

public interface PaymentGateway {

    Payment getStatusByOrderId(long orderNumber);
}
