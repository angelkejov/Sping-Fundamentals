package com.softuni.exam.service;

import com.softuni.exam.model.service.FoodServiceModel;
import org.springframework.stereotype.Service;

@Service
public interface FoodService {

    void addFood(FoodServiceModel foodServiceModel);
}
