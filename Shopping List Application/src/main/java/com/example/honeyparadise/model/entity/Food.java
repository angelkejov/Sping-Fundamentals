package com.example.honeyparadise.model.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "foods")
public class Food extends Base {

    private String foodName;

    private Integer calories;

    private Double price;

    public Food() {

    }

    public Food(String foodName, Integer calories, Double price) {
        this.foodName = foodName;
        this.calories = calories;
        this.price = price;
    }

    public Integer getCalories() {
        return calories;
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }
}
