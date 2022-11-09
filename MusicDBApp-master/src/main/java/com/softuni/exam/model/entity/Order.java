package com.softuni.exam.model.entity;


import com.softuni.exam.model.enums.CategoryType;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
public class Order extends Base {

    private String name;

    private String description;

    private BigDecimal price;

    private LocalDateTime orderTime;

    private CategoryType category;

    @ManyToOne
    private User user;

    public Order() {

    }

    public Order(String name, String description,
                 BigDecimal price, LocalDateTime orderTime, CategoryType category, User user) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.orderTime = orderTime;
        this.category = category;
        this.user = user;
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

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
    }

    public CategoryType getCategory() {
        return category;
    }

    public void setCategory(CategoryType category) {
        this.category = category;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
