package com.fiap.digidine.applications.ports.outbound;

import com.fiap.digidine.domain.model.OrderModel;

import java.util.List;

public interface ListOrdersOutputPort {

    List<OrderModel> listOrders();
}
