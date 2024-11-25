package com.fiap.digidine.infrastructure.gateways;

import com.fiap.digidine.application.gateways.PaymentGateway;
import com.fiap.digidine.domain.entities.Payment;
import com.fiap.digidine.domain.entities.enums.PaymentStatus;
import com.fiap.digidine.domain.repositories.PaymentRepository;
import com.fiap.digidine.infrastructure.gateways.mappers.PaymentEntityMapper;
import com.fiap.digidine.infrastructure.persistence.OrderMongoDBRepository;
import com.fiap.digidine.infrastructure.persistence.PaymentMongoDBRepository;
import com.fiap.digidine.infrastructure.persistence.entities.mongodb.PaymentEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Random;

public class PaymentRepositoryGateway implements PaymentGateway {

    private final PaymentMongoDBRepository paymentRepository;

    private final OrderMongoDBRepository orderRepository;
    private final PaymentEntityMapper paymentEntityMapper;
    private final Random random = new Random();

    public PaymentRepositoryGateway(PaymentMongoDBRepository paymentRepository, OrderMongoDBRepository orderRepository, PaymentEntityMapper paymentEntityMapper) {
        this.paymentRepository = paymentRepository;
        this.orderRepository = orderRepository;
        this.paymentEntityMapper = paymentEntityMapper;
    }

    @Override
    public Payment getStatusByOrderId(long orderNumber) {
        // Simular alternância de status entre APROVADO e REPROVADO
        PaymentStatus mockStatus = random.nextBoolean() ? PaymentStatus.APROVADO : PaymentStatus.REJEITADO;

        // Buscar a entidade de pagamento correspondente e atualizar o status
        PaymentEntity paymentEntity = paymentRepository.findByOrderId(orderRepository.findByOrderNumber(orderNumber).getId());
        paymentEntity.setPaymentStatus(mockStatus);

        // Mapear para o domínio e retornar
        return paymentEntityMapper.toDomain(paymentEntity);
    }
}
