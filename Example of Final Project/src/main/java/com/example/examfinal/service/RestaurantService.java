package com.example.examfinal.service;

import com.example.examfinal.model.view.RestaurantDetailsView;
import com.example.examfinal.model.view.RestaurantViewModel;

import java.util.List;

public interface RestaurantService {
    List<RestaurantViewModel> getAllRestaurants();

    void initializeRestaurants();

    RestaurantDetailsView findById(Long id);



}
