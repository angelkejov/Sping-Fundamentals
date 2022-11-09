package com.example.examfinal.model.binding;

import com.example.examfinal.model.entity.enums.AreaOfBg;
import com.example.examfinal.model.entity.enums.CapitalOrNot;

import javax.validation.constraints.NotNull;

public class CityUpdateBindingModel {

    private Long id;

    @NotNull
    private String description;

    @NotNull
    private String imageUrl;

    @NotNull
    private Integer year;

    @NotNull
    private String name;

    @NotNull
    private CapitalOrNot capitalOrNot;

    @NotNull
    private String mayor;

    @NotNull
    private AreaOfBg areaOfBg;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CapitalOrNot getCapitalOrNot() {
        return capitalOrNot;
    }

    public void setCapitalOrNot(CapitalOrNot capitalOrNot) {
        this.capitalOrNot = capitalOrNot;
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
