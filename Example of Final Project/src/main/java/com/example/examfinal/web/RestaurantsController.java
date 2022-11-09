package com.example.examfinal.web;
import com.example.examfinal.service.RestaurantService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class RestaurantsController {
    private final RestaurantService restaurantService;
    private final ModelMapper modelMapper;

    public RestaurantsController(RestaurantService restaurantService, ModelMapper modelMapper) {
        this.restaurantService = restaurantService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/restaurants/all")
    public String allPlaces(Model model) {
        model.addAttribute("restaurantsAll", restaurantService.getAllRestaurants());
        return "restaurants";
    }

    @GetMapping("/restaurants/{id}/restaurants-details")
    public String showPlace(@PathVariable Long id, Model model) {

        model.addAttribute("restaurants", this.restaurantService.findById(id));
        return "restaurants-details";
    }













}
