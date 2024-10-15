package com.fiap.digidine.infrastructure.controllers.dtos;

import com.fiap.digidine.domain.entities.enums.Category;

public record ProductRequest(String name, String description, Double price, Category category) {
}
