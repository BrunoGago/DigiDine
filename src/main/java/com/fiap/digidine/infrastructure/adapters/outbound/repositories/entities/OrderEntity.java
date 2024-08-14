package com.fiap.digidine.infrastructure.adapters.outbound.repositories.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
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
    @JoinColumn(name = "customer_id", nullable = true)
    private CustomerEntity customer;
    @Enumerated(EnumType.STRING)
    private OrderStatusEnum orderStatus;
    private LocalDateTime creationTime;
    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderedItemEntity> itens;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public CustomerEntity getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerEntity customer) {
        this.customer = customer;
    }

    public OrderStatusEnum getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatusEnum orderStatus) {
        this.orderStatus = orderStatus;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(LocalDateTime creationTime) {
        this.creationTime = creationTime;
    }

    public List<OrderedItemEntity> getItens() {
        return itens;
    }

    public void setItens(List<OrderedItemEntity> itens) {
        this.itens = itens;
    }
}
