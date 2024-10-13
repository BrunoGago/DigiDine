package com.fiap.digidine.infrastructure.gateways;

import com.fiap.digidine.application.gateways.OrderGateway;
import com.fiap.digidine.domain.entities.Order;
import com.fiap.digidine.domain.entities.enums.OrderStatus;
import com.fiap.digidine.infrastructure.gateways.mappers.OrderEntityMapper;
import com.fiap.digidine.infrastructure.persistence.OrderRepository;
import com.fiap.digidine.infrastructure.persistence.entities.OrderEntity;
import com.fiap.digidine.infrastructure.persistence.entities.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class OrderRepositoryGateway implements OrderGateway {

    private final OrderRepository orderRepository;
    private final OrderEntityMapper orderEntityMapper;

    @Autowired
    public OrderRepositoryGateway(OrderRepository ordersRepository, OrderEntityMapper orderEntityMapper) {
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
        List<OrderEntity> orderEntities = orderRepository.findAll();
        if (orderEntities == null) {
            throw new IllegalArgumentException();
        }
        return orderEntityMapper.toDomains(orderEntities);
    }

    @Override
    public void checkoutOrder(Order order) {
        //IMPLEMENTAR
    }
}
