package com.softuni.exam.model.entity;


import com.softuni.exam.model.enums.DrinkType;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "drinks")
public class Drink extends Base{

    private String drinkName;

    private DrinkType drinkType;

    private Double price;

    public Drink() {

    }

    public Drink(String drinkName, DrinkType drinkType, Double price) {
        this.drinkName = drinkName;
        this.drinkType = drinkType;
        this.price = price;
    }

    public String getDrinkName() {
        return drinkName;
    }

    public void setDrinkName(String drinkName) {
        this.drinkName = drinkName;
    }

    public DrinkType getDrinkType() {
        return drinkType;
    }

    public void setDrinkType(DrinkType drinkType) {
        this.drinkType = drinkType;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
