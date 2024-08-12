package com.fiap.digidine.domain.model;

import com.fiap.digidine.domain.model.enums.CategoryEnum;

import java.math.BigDecimal;

public class ProductModel {

    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private CategoryEnum category;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public CategoryEnum getCategory() {
        return category;
    }

    public void setCategory(CategoryEnum category) {
        this.category = category;
    }
}
