package com.example.coffeeshop.model;

import com.example.coffeeshop.model.enums.TypeOfDrink;

import javax.persistence.*;

@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TypeOfDrink name;

    @Column(name = "needed_time")
    private Integer neededTime;

    public Category() {

    }

    public Category(TypeOfDrink name, Integer neededTime) {
        this.name = name;
        this.neededTime = neededTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public Integer getNeededTime() {
        return neededTime;
    }

    public void setNeededTime(Integer neededTime) {
        this.neededTime = neededTime;
    }

    public TypeOfDrink getName() {
        return name;
    }

    public void setName(TypeOfDrink name) {
        this.name = name;
    }
}
