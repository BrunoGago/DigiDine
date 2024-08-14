package com.fiap.digidine.applications.dto;

import jakarta.annotation.Nullable;

import java.util.List;
import java.util.UUID;

public class OrderDto {
    private UUID id;
    @Nullable
    private UUID customerId;
    private List<UUID> productIds;
    private double totalAmount;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Nullable
    public UUID getCustomerId() {
        return customerId;
    }

    public void setCustomerId(@Nullable UUID customerId) {
        this.customerId = customerId;
    }

    public List<UUID> getProductIds() {
        return productIds;
    }

    public void setProductIds(List<UUID> productIds) {
        this.productIds = productIds;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}