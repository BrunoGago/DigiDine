package com.fiap.digidine.domain.model;

import java.time.LocalTime;
import java.util.UUID;

public class OrderModel {
    private UUID id;

    private double tipFee;

    private double total;

    private String paymentMethod;

    private int quantity;

    private String status;
    
    private LocalTime timeLapse;

    public OrderModel(UUID id, double tipFee, double total, String paymentMethod, int quantity, String status, LocalTime timeLapse) {
        this.id = id;
        this.tipFee = tipFee;
        this.total = total;
        this.paymentMethod = paymentMethod;
        this.quantity = quantity;
        this.status = status;
        this.timeLapse = timeLapse;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public double getTipFee() {
        return tipFee;
    }

    public void setTipFee(double tipFee) {
        this.tipFee = tipFee;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalTime getTimeLapse() {
        return timeLapse;
    }

    public void setTimeLapse(LocalTime timeLapse) {
        this.timeLapse = timeLapse;
    }
}
