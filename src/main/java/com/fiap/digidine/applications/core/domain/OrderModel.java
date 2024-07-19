package com.fiap.digidine.applications.core.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fiap.digidine.applications.core.domain.enums.PaymentMethodEnum;
import com.fiap.digidine.applications.core.domain.enums.StatusEnum;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "TB_ORDER")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private PaymentMethodEnum paymentMehtod;

    @Column
    private Integer quantity;

    @Column
    private StatusEnum status;

    @Column
    @CreatedDate
    private LocalDateTime creationDate;

    @Column(nullable = false)
    @LastModifiedDate
    private LocalDateTime lastUpdateDate;

    public OrderModel() {
    }

    public OrderModel(PaymentMethodEnum paymentMehtod, Integer quantity, StatusEnum status, LocalDateTime creationDate, LocalDateTime lastUpdateDate) {
        this.paymentMehtod = paymentMehtod;
        this.quantity = quantity;
        this.status = status;
        this.creationDate = creationDate;
        this.lastUpdateDate = lastUpdateDate;
    }

    public PaymentMethodEnum getPaymentMehtod() {
        return paymentMehtod;
    }

    public void setPaymentMehtod(PaymentMethodEnum paymentMehtod) {
        this.paymentMehtod = paymentMehtod;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDateTime getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(LocalDateTime lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

}
