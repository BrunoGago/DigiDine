package com.fiap.digidine.applications.ports.inbound;

import com.fiap.digidine.domain.model.OrderModel;
import java.util.UUID;

public interface ListOrdersInputPort {

    OrderModel listOrders(UUID id);
}
