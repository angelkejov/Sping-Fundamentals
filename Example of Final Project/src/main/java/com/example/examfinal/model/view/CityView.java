package com.example.examfinal.model.view;

import com.example.examfinal.model.entity.enums.AreaOfBg;
import com.example.examfinal.model.entity.enums.CapitalOrNot;
import com.example.examfinal.model.entity.enums.NameType;

public class CityView {
    private Long id;
    private String description;
    private Integer year;
    private CapitalOrNot capitalOrNot;
    private String imageUrl;
    private String mayor;
    private AreaOfBg areaOfBg;
    private String name;
    private NameType type;


    public CityView() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public NameType getType() {
        return type;
    }

    public void setType(NameType type) {
        this.type = type;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getMayor() {
        return mayor;
    }

    public void setMayor(String mayor) {
        this.mayor = mayor;
    }

    public AreaOfBg getAreaOfBg() {
        return areaOfBg;
    }

    public void setAreaOfBg(AreaOfBg areaOfBg) {
        this.areaOfBg = areaOfBg;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CapitalOrNot getCapitalOrNot() {
        return capitalOrNot;
    }

    public void setCapitalOrNot(CapitalOrNot capitalOrNot) {
        this.capitalOrNot = capitalOrNot;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }


}
