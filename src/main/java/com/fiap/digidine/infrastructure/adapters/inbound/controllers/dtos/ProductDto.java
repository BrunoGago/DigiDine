package com.fiap.digidine.infrastructure.adapters.inbound.controllers.dtos;

import com.fiap.digidine.domain.model.enums.CategoryEnum;

import java.math.BigDecimal;

public class ProductDto {

    private String name;

    private String description;

    private BigDecimal price;

    private CategoryEnum category;

    public ProductDto(String name, BigDecimal price, CategoryEnum category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public CategoryEnum getCategory() {
        return category;
    }

    public void SetCategory(CategoryEnum category) {
        this.category = category;
    }

}
