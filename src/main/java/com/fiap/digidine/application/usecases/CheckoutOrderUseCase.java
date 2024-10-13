package com.fiap.digidine.application.usecases;

import com.fiap.digidine.application.gateways.OrderGateway;
import com.fiap.digidine.domain.entities.Order;


public class CheckoutOrderUseCase {

    private final OrderGateway ordersGateway;

    public CheckoutOrderUseCase(OrderGateway ordersGateway) {
        this.ordersGateway = ordersGateway;
    }

    public void checkoutOrder(Order order) {
        // integrar com o sistema de pagamento (ex: Mercado Pago)
        // Após o pagamento, salvar o pedido
        ordersGateway.checkoutOrder(order);
    }
}
