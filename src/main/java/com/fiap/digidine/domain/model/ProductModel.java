package com.fiap.digidine.domain.model;

import com.fiap.digidine.domain.model.enums.CategoryEnum;

import java.math.BigDecimal;
import java.util.UUID;

public class ProductModel {

    private UUID id;
    private String name;
    private String description;
    private Double price;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public CategoryEnum getCategory() {
        return category;
    }

    public void setCategory(CategoryEnum category) {
        this.category = category;
    }
}
