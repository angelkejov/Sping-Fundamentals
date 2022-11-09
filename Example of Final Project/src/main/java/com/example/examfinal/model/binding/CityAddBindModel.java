package com.example.examfinal.model.binding;


import com.example.examfinal.model.entity.enums.AreaOfBg;
import com.example.examfinal.model.entity.enums.CapitalOrNot;

import javax.validation.constraints.*;

public class CityAddBindModel {

    @NotBlank
    private String name;

    @NotEmpty
    private String description;

    @NotNull
    @Positive
    private Integer year;

    @NotNull
    private CapitalOrNot capitalOrNot;

    @NotEmpty
    private String imageUrl;

    @Size(min = 3)
    private String mayor;

    @NotNull
    private AreaOfBg areaOfBg;


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

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
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
}