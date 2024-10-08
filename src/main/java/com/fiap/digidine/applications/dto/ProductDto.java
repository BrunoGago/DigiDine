package com.fiap.digidine.applications.dto;

import com.fiap.digidine.domain.model.enums.CategoryEnum;
import jakarta.validation.constraints.Email;
import org.hibernate.validator.constraints.br.CPF;

import java.math.BigDecimal;
import java.util.UUID;

public class ProductDto {
    private UUID id;
    private String name;
    private Double price;
    private String description;
    private CategoryEnum category;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CategoryEnum getCategory() {
        return category;
    }

    public void setCategory(CategoryEnum category) {
        this.category = category;
    }
}
