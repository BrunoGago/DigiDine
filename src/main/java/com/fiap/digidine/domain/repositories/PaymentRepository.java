package com.fiap.digidine.domain.repositories;

import com.fiap.digidine.domain.entities.Payment;

public interface PaymentRepository {
    Payment save(Payment payment);
    Payment findByOrderId(String orderId);
    void update(Payment payment);
}
