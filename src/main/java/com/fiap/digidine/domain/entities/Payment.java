package com.fiap.digidine.domain.entities;

import com.fiap.digidine.domain.entities.enums.PaymentMethod;
import com.fiap.digidine.domain.entities.enums.PaymentStatus;

public class Payment {

    private long paymentNumber;
    private long orderNumber;
    private PaymentStatus paymentStatus;
    private PaymentMethod method; // Ex: "QRCode"

    public Payment() {
    }

    public Payment(long paymentNumber, PaymentStatus paymentStatus, PaymentMethod method) {
        this.paymentNumber = paymentNumber;
        this.paymentStatus = paymentStatus;
        this.method = method;
    }

    public long getPaymentNumber() {
        return paymentNumber;
    }

    public void setPaymentNumber(long paymentNumber) {
        this.paymentNumber = paymentNumber;
    }

    public long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(long orderNumber) {
        this.orderNumber = orderNumber;
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
