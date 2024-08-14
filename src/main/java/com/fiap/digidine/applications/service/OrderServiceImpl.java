package com.fiap.digidine.applications.service;

import com.fiap.digidine.applications.dto.OrderDto;
import com.fiap.digidine.applications.mappers.OrderMapper;
import com.fiap.digidine.applications.ports.inbound.OrderServicePort;
import com.fiap.digidine.domain.model.CustomerModel;
import com.fiap.digidine.domain.model.OrderModel;
import com.fiap.digidine.domain.ports.outbound.CustomerRepositoryPort;
import com.fiap.digidine.domain.ports.outbound.OrderRepositoryPort;
import com.fiap.digidine.domain.ports.outbound.ProductRepositoryPort;
import org.springframework.stereotype.Service;
import com.fiap.digidine.domain.model.ProductModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import static com.fiap.digidine.domain.model.enums.OrderStatusEnum.PRONTO;

@Service
public class OrderServiceImpl implements OrderServicePort {

    private final OrderRepositoryPort orderRepositoryPort;
    private final CustomerRepositoryPort customerRepositoryPort;
    private final ProductRepositoryPort productRepositoryPort;
    private final OrderMapper orderMapper;

    public OrderServiceImpl(OrderRepositoryPort orderRepositoryPort, CustomerRepositoryPort customerRepositoryPort, OrderMapper orderMapper, ProductRepositoryPort productRepositoryPort) {
        this.orderRepositoryPort = orderRepositoryPort;
        this.customerRepositoryPort = customerRepositoryPort;
        this.orderMapper = orderMapper;
        this.productRepositoryPort = productRepositoryPort;
    }

    @Override
    public void createOrder(OrderDto orderDto) {
        CustomerModel customerModel = customerRepositoryPort.getById(orderDto.getCustomerId());
        List<ProductModel> productModelList = new ArrayList<>();
        for (UUID id : orderDto.getProductIds()) {
            productModelList.add(productRepositoryPort.getById(id).get());
        }
        orderRepositoryPort.create(orderMapper.toModel(orderDto, customerModel, productModelList));
    }

    @Override
    public void updateOrder(UUID id, OrderDto orderDto) {
        CustomerModel customerModel = customerRepositoryPort.getById(orderDto.getCustomerId());
        List<ProductModel> productModelList = new ArrayList<>();
        for (UUID productId : orderDto.getProductIds()) {
            productModelList.add(productRepositoryPort.getById(productId).get());
        }
        orderRepositoryPort.update(id, orderMapper.toModel(orderDto, customerModel, productModelList));
    }

    @Override
    public List<OrderDto> listOrders() {
        return orderRepositoryPort.findAll().stream()
                .map(orderMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void fakeCheckout(UUID id) {
        orderRepositoryPort.findById(id).ifPresent(orderModel -> orderModel.setOrderStatus(PRONTO));
    }
}
