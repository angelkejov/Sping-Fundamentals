package com.example.examfinal.init;

import com.example.examfinal.service.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DBInit implements CommandLineRunner {


    private final UserService userService;
    private final CityService cityService;
    private final PlaceService placeService;
    private final RestaurantService restaurantService;
    private final AccommodationService accommodationService;

    public DBInit(UserService userService, CityService cityService, PlaceService placeService, RestaurantService restaurantService, AccommodationService accommodationService) {
        this.userService = userService;
        this.cityService = cityService;
        this.placeService = placeService;
        this.restaurantService = restaurantService;
        this.accommodationService = accommodationService;
    }



    @Override
    public void run(String... args) throws Exception {
        userService.initializeUsersAndRoles();
        cityService.initializeCities();
        placeService.initializePlace();
        restaurantService.initializeRestaurants();
        accommodationService.initializeAccommodation();
    }
}