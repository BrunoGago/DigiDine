package com.fiap.digidine.infrastructure.gateways.mappers;

import com.fiap.digidine.domain.entities.Order;
import com.fiap.digidine.domain.entities.Payment;
import com.fiap.digidine.infrastructure.persistence.entities.OrderEntity;
import com.fiap.digidine.infrastructure.persistence.entities.PaymentEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PaymentEntityMapper {


    public Payment toDomain(PaymentEntity entity){
        return new Payment(
                entity.getOrderId(),
                entity.isApproved(),
                entity.getMethod()
        );
    }

}
