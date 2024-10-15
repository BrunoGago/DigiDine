package com.fiap.digidine.domain.entities;

import com.fiap.digidine.domain.entities.enums.PaymentMethod;
import com.fiap.digidine.domain.entities.enums.PaymentStatus;

public class Payment {
    private String orderId;
    private PaymentStatus paymentStatus;
    private PaymentMethod method; // Ex: "QRCode"

    public Payment() {
    }

    public Payment(String orderId, PaymentStatus paymentStatus, PaymentMethod method) {
        this.orderId = orderId;
        this.paymentStatus = paymentStatus;
        this.method = method;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public PaymentMethod getMethod() {
        return method;
    }

    public void setMethod(PaymentMethod method) {
        this.method = method;
    }
}
