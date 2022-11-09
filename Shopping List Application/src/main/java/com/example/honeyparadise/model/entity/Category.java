package com.example.honeyparadise.model.entity;

import com.example.honeyparadise.model.enums.HoneyType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "categories")
public class Category extends Base{

    @Column(unique = true)
    private HoneyType category;

    @Column(columnDefinition = "TEXT")
    private String description;

    public Category() {

    }

    public Category(HoneyType category, String description) {
        this.category = category;
        this.description = description;
    }

    public HoneyType getCategory() {
        return category;
    }

    public void setCategory(HoneyType category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
