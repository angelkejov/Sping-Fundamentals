package com.example.examfinal.model.entity;

import com.example.examfinal.model.entity.enums.AreaOfBg;
import com.example.examfinal.model.entity.enums.CapitalOrNot;

import javax.persistence.*;

@Entity
@Table(name = "cities")
public class CityEntity extends BaseEntity {
    //name, description, year, Capital ot not(enum), imageUrl, mayor, area of Bg
    @Column(nullable  = false)
    private String name;
    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;
    private Integer year;
    @Enumerated(EnumType.STRING)
    private CapitalOrNot capitalOrNot;
    @Column(nullable = false)
    private String imageUrl;
    private String mayor;
    @Enumerated(EnumType.STRING)
    private AreaOfBg areaOfBg;
    @ManyToOne
    private UserEntity user;



    public CityEntity() {
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

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }


}
