package com.example.examfinal.model.view;

import com.example.examfinal.model.entity.enums.PriceEnum;
import com.example.examfinal.model.entity.enums.RestaurantType;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class RestaurantDetailsView {
    private String id;
    private String name;
    private String rating;
    private PriceEnum priceRange;
    private RestaurantType restaurantType;
    private String address;
    private String img;
    private String menu;

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

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public PriceEnum getPriceRange() {
        return priceRange;
    }

    public void setPriceRange(PriceEnum priceRange) {
        this.priceRange = priceRange;
    }

    public RestaurantType getRestaurantType() {
        return restaurantType;
    }

    public void setRestaurantType(RestaurantType restaurantType) {
        this.restaurantType = restaurantType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }
}
