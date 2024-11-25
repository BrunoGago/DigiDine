package com.fiap.digidine.infrastructure.controllers.dtos;

import com.fiap.digidine.domain.entities.enums.Category;

public record ProductResponse(long productNumber, String name, String description, Double price, Category category) {
}
