package com.fiap.digidine.infrastructure.adapters.outbound.repositories.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fiap.digidine.domain.model.CustomerModel;
import com.fiap.digidine.domain.model.enums.OrderStatusEnum;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "TB_ORDER")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @ManyToOne
    private CustomerEntity customer;
    @Enumerated(EnumType.STRING)
    private OrderStatusEnum orderStatus;
    private LocalDateTime creationTime;
    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderedItemEntity> itens;
}
