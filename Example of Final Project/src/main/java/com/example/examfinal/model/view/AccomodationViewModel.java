package com.example.examfinal.model.view;

import com.example.examfinal.model.entity.enums.TypeAccommodationEnum;

import javax.persistence.ManyToOne;

public class AccomodationViewModel {
    private TypeAccommodationEnum type;
    private Integer numberOfRooms;
    private String name;
    private String id;
    private String imageUrl;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
