package com.softuni.exam.model.binding;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class AddFoodBindingModel {

    @NotBlank(message = "Food name cannot be empty")
    @Size(min = 3, max = 20, message = "Name must be between" +
            " 3 and 20 characters")
    private String foodName;

    @NotBlank(message = "Calories cannot be empty")
    @Positive
    private Integer calories;

    @NotBlank(message = "Food cannot be free")
    @Positive
    private Double price;

    @NotBlank(message = "Image url can not be null or empty")
    @Size(min = 5, message = "Image url must be more than 5 characters")
    private String imgUrl;

    public AddFoodBindingModel() {

    }

    public AddFoodBindingModel(String foodName, Integer calories, Double price, String imgUrl) {
        this.foodName = foodName;
        this.calories = calories;
        this.price = price;
        this.imgUrl = imgUrl;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
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

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
