package com.fiap.digidine.applications.service;

import com.fiap.digidine.applications.dto.OrderDto;
import com.fiap.digidine.applications.mappers.OrderMapper;
import com.fiap.digidine.applications.ports.inbound.OrderServicePort;
import com.fiap.digidine.domain.model.OrderModel;
import com.fiap.digidine.domain.ports.outbound.OrderRepositoryPort;
import com.fiap.digidine.domain.ports.outbound.ProductRepositoryPort;
import org.springframework.stereotype.Service;
import com.fiap.digidine.domain.model.ProductModel;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import static com.fiap.digidine.domain.model.enums.OrderStatusEnum.PRONTO;

@Service
public class OrderServiceImpl implements OrderServicePort {

    private final OrderRepositoryPort orderRepositoryPort;

    private final ProductRepositoryPort productRepositoryPort;
    private final OrderMapper orderMapper;

    public OrderServiceImpl(OrderRepositoryPort orderRepositoryPort, OrderMapper orderMapper, ProductRepositoryPort productRepositoryPort) {
        this.orderRepositoryPort = orderRepositoryPort;
        this.orderMapper = orderMapper;
        this.productRepositoryPort = productRepositoryPort;
    }

    @Override
    public void createOrder(OrderDto orderDto) {
        orderRepositoryPort.create(orderMapper.toModel(orderDto));
    }

    @Override
    public void updateOrder(UUID id, OrderDto orderDto) {
        orderRepositoryPort.update(id, orderMapper.toModel(orderDto));
    }

    @Override
    public List<OrderDto> listOrders() {
        return orderRepositoryPort.findAll().stream()
                .map(orderMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void fakeCheckout(UUID id) {
        Optional<OrderModel> orderModelOptional = orderRepositoryPort.findById(id);
        if (orderModelOptional != null) {
            orderModelOptional.get().setOrderStatus(PRONTO);
        }
    }
}
