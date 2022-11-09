package com.example.examfinal.model.entity;

import com.example.examfinal.model.entity.enums.PriceEnum;
import com.example.examfinal.model.entity.enums.RestaurantType;

import javax.persistence.*;

@Entity
@Table(name = "restaurants")
public class Restaurant extends BaseEntity {
    @ManyToOne
    private CityEntity city;
    @Column(nullable = false)
    private String name;
    private String rating;
    @Enumerated(EnumType.STRING)
    private PriceEnum priceRange;
    @Enumerated(EnumType.STRING)
    private RestaurantType restaurantType;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private String img;
    @Column(nullable = false, columnDefinition = "TEXT")
    private String menu;

    public Restaurant() {
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

    public CityEntity getCity() {
        return city;
    }

    public void setCity(CityEntity city) {
        this.city = city;
    }
}
