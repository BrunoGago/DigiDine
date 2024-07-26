package com.fiap.digidine.applications.ports.inbound;

import com.fiap.digidine.domain.model.OrderModel;

import java.util.List;

public interface ListOrdersInputPort {

    List<OrderModel> listOrders();
}
