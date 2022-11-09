package com.example.thymeleafandvalidations.model.dto;

import com.sun.istack.NotNull;

import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class CompanyDTO {

    @NotNull
    @Size(min = 2, max = 10, message = "Invalid name")
    private String name;

    @NotNull
    @Size(min = 2, max = 10, message = "Invalid town")
    private String town;

    @NotNull
    @Positive
    @Size(min = 10, message = "Invalid budget")
    private Integer budget;

    @NotNull
    @Size(min = 10, message = "Invalid description")
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public Integer getBudget() {
        return budget;
    }

    public void setBudget(Integer budget) {
        this.budget = budget;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "CompanyDTO{" +
                "name='" + name + '\'' +
                ", town='" + town + '\'' +
                ", budget=" + budget +
                ", description='" + description + '\'' +
                '}';
    }
}
