package com.fiap.digidine.infrastructure.persistence.entities.mongodb;

import com.fiap.digidine.domain.entities.enums.Category;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "products") // Define a coleção no MongoDB
public class ProductEntity {

    @Id // Define o identificador do documento
    private String id;
    private Long productNumber;
    private String name;
    private String description;
    private Double price;
    private Category category;

    public ProductEntity() {
    }

    public ProductEntity(Long productNumber, String name, String description, Double price, Category category) {
        this.productNumber = productNumber;
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
    }

    // Getters and Setters

    public Long getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(Long productNumber) {
        this.productNumber = productNumber;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
