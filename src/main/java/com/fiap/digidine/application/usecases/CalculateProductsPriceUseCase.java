package com.fiap.digidine.application.usecases;

import com.fiap.digidine.application.gateways.OrderGateway;
import com.fiap.digidine.domain.entities.Product;

import java.util.List;

public class CalculateProductsPriceUseCase {

    private final OrderGateway ordersGateway;

    public CalculateProductsPriceUseCase(OrderGateway ordersGateway) {
        this.ordersGateway = ordersGateway;
    }

    public double calculatePrice(List<Long> products) {
        return ordersGateway.calculatePrice(products);
    }
}
