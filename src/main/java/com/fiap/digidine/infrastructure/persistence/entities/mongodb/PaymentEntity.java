package com.fiap.digidine.infrastructure.persistence.entities.mongodb;

import com.fiap.digidine.domain.entities.enums.PaymentMethod;
import com.fiap.digidine.domain.entities.enums.PaymentStatus;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "payments") // Define a coleção do MongoDB
public class PaymentEntity {

    @Id // Define o identificador do documento
    private String id;
    @DBRef
    private String orderId;
    private long paymentNumber;
    private PaymentStatus paymentStatus;
    private PaymentMethod method; // Ex: "QRCode"

    public PaymentEntity() {
    }

    public PaymentEntity(String orderId, long paymentNumber, PaymentStatus paymentStatus, PaymentMethod method) {
        this.orderId = orderId;
        this.paymentNumber = paymentNumber;
        this.paymentStatus = paymentStatus;
        this.method = method;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public long getPaymentNumber() {
        return paymentNumber;
    }
    public void setPaymentNumber(long paymentNumber) {
        this.paymentNumber = paymentNumber;
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
