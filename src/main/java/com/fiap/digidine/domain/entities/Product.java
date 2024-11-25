package com.fiap.digidine.domain.entities;

import com.fiap.digidine.domain.entities.enums.Category;

public class Product {

    private Long productNumber;
    private String name;
    private String description;
    private Double price;
    private Category category;

    public Product(){

    }
    public Product(Long productNumber, String name, String description, Double price, Category category) {
        this.productNumber = productNumber;
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
    }

    public Long getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(Long productNumber) {
        this.productNumber = productNumber;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}