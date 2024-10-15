package com.fiap.digidine.application.usecases;

import com.fiap.digidine.application.gateways.OrderGateway;
import com.fiap.digidine.domain.entities.Customer;
import com.fiap.digidine.domain.entities.Order;
import com.fiap.digidine.domain.entities.Product;

import java.util.List;


public class CheckoutOrderUseCase {

    private final OrderGateway ordersGateway;

    public CheckoutOrderUseCase(OrderGateway ordersGateway) {
        this.ordersGateway = ordersGateway;
    }

    public void checkoutOrder(List<Product> products, Customer customer) {
        // integrar com o sistema de pagamento (ex: Mercado Pago)
        // Após o pagamento, salvar o pedido
        ordersGateway.checkoutOrder(products, customer);
    }
}
