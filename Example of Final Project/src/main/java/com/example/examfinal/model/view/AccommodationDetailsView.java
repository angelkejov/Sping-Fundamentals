package com.example.examfinal.model.view;

import com.example.examfinal.model.entity.CityEntity;
import com.example.examfinal.model.entity.enums.TypeAccommodationEnum;

public class AccommodationDetailsView {
    private TypeAccommodationEnum type;
    private Integer numberOfRooms;
    private String name;
    private String id;
    private String description;
    private Double price;
    private String address;
    private Double rating;
    private Boolean wi_fi;
    private String imageUrl;
    private CityEntity city;

    public TypeAccommodationEnum getType() {
        return type;
    }

    public void setType(TypeAccommodationEnum type) {
        this.type = type;
    }

    public Integer getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(Integer numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Boolean getWi_fi() {
        return wi_fi;
    }

    public void setWi_fi(Boolean wi_fi) {
        this.wi_fi = wi_fi;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public CityEntity getCity() {
        return city;
    }

    public void setCity(CityEntity city) {
        this.city = city;
    }
}
