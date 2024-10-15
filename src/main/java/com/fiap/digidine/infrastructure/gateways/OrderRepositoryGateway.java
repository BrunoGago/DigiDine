package com.fiap.digidine.infrastructure.gateways;

import com.fiap.digidine.application.gateways.OrderGateway;
import com.fiap.digidine.domain.entities.Customer;
import com.fiap.digidine.domain.entities.Order;
import com.fiap.digidine.domain.entities.Product;
import com.fiap.digidine.domain.entities.enums.OrderStatus;
import com.fiap.digidine.infrastructure.gateways.mappers.CustomerEntityMapper;
import com.fiap.digidine.infrastructure.gateways.mappers.OrderEntityMapper;
import com.fiap.digidine.infrastructure.persistence.OrderMongoDBRepository;
import com.fiap.digidine.infrastructure.persistence.entities.mongodb.OrderEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class OrderRepositoryGateway implements OrderGateway {

    private final OrderMongoDBRepository orderRepository;
    private final OrderEntityMapper orderEntityMapper;

    @Autowired
    public OrderRepositoryGateway(OrderMongoDBRepository ordersRepository, OrderEntityMapper orderEntityMapper) {
        this.orderRepository = ordersRepository;
        this.orderEntityMapper = orderEntityMapper;
    }


    @Override
    public void createOrder(Order order) {
        Order baseOrder = new Order();

        order.setOrderStatus(OrderStatus.RECEBIDO);

        orderEntityMapper.toDomain(orderRepository.save(orderEntityMapper.toEntity(order)));
    }

    @Override
    public Order updateOrderStatus(String id, OrderStatus status) {
        Optional<OrderEntity> optionalOrderEntity = orderRepository.findById(id);

        Order existingOrder = optionalOrderEntity
                .map(orderEntityMapper::toDomain)
                .orElseThrow(() -> new IllegalArgumentException("Pedido não cadastrado anteriormente!"));

        // Atualizando os dados do produto
        existingOrder.setOrderStatus(status);

        // Salvando a entidade atualizada
        orderRepository.save(orderEntityMapper.toEntity(existingOrder));

        return existingOrder;
    }

    @Override
    public Order updateOrder(String id, Order order) {
        Optional<OrderEntity> optionalOrderEntity = orderRepository.findById(id);

        Order existingOrder = optionalOrderEntity
                .map(orderEntityMapper::toDomain)
                .orElseThrow(() -> new IllegalArgumentException("Pedido não cadastrado anteriormente!"));

        // Atualizando os dados do produto
        existingOrder.setCustomer(order.getCustomer());
        existingOrder.setProducts(order.getProducts());
        existingOrder.setOrderStatus(order.getOrderStatus());
        existingOrder.setTotalPrice(order.getTotalPrice());

        // Salvando a entidade atualizada
        orderRepository.save(orderEntityMapper.toEntity(existingOrder));

        return existingOrder;
    }

    @Override
    public List<Order> listOrders() {
        List<OrderEntity> orderEntities = orderRepository
                .findByStatusNotOrderByStatusAscCreatedAtAsc("Finalizado");

        if (orderEntities == null || orderEntities.isEmpty()) {
            throw new IllegalArgumentException();
        }

        // Mapeamento para objetos de domínio
        List<Order> orders = orderEntityMapper.toDomains(orderEntities);

        // Ordenação customizada dos status
        orders.sort(Comparator.comparingInt(this::getStatusPriority)
                .thenComparing(Order::getCreatedAt));

        return orders;
    }

    // Define a prioridade dos status
    private int getStatusPriority(Order order) {
        switch (order.getOrderStatus()) {
            case OrderStatus.PRONTO: return 1;
            case OrderStatus.EM_PREPARACAO: return 2;
            case OrderStatus.RECEBIDO: return 3;
            default: return Integer.MAX_VALUE;
        }
    }

    @Override
    public String checkoutOrder(List<Product> products, Customer customer) {
        Order order = new Order(UUID.randomUUID().toString(), customer, products, calculatePrice(products), OrderStatus.RECEBIDO, LocalDateTime.now());
        createOrder(order);
        return order.getOrderNumber();
    }

    @Override
    public Double calculatePrice(List<Product> products) {
        double totalPrice = 0.0;

        for (Product product : products) {
            totalPrice += product.getPrice();
        }
        return totalPrice;
    }

    @Override
    public OrderStatus getOrderStatus(String orderNumber) {
        Optional<OrderEntity> optionalOrderEntity = orderRepository.findById(orderNumber);

        Order order = optionalOrderEntity
                .map(orderEntityMapper::toDomain)
                .orElseThrow(() -> new IllegalArgumentException("Pedido não cadastrado anteriormente!"));

        return order.getOrderStatus();
    }
}
