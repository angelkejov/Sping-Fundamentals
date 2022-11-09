package com.example.examfinal.model.entity;


import com.example.examfinal.model.entity.enums.TypeAccommodationEnum;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "accommodations")
public class Accommodation extends BaseEntity {
    private TypeAccommodationEnum type;
    @Column(nullable = false)
    private Integer numberOfRooms;
    private String name;
    @Column(nullable = false,columnDefinition = "TEXT")
    private String description;
    private Double price;
    @ManyToOne
    private CityEntity city;
    @Column(nullable = false,columnDefinition = "TEXT")
    private String address;
    @Column(nullable = false)
    private Double rating;
    private Boolean wi_fi;
    @Column(nullable = false)
    private String imageUrl;

    public Accommodation() {
    }

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


    public CityEntity getCity() {
        return city;
    }

    public void setCity(CityEntity city) {
        this.city = city;
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
}
