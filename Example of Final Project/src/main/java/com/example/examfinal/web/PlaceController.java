package com.example.examfinal.web;

import com.example.examfinal.service.CityService;
import com.example.examfinal.service.PlaceService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class PlaceController {
    private final PlaceService placeService;
    private final CityService cityService;
    private final ModelMapper modelMapper;

    public PlaceController(PlaceService placeService, CityService cityService, ModelMapper modelMapper) {
        this.placeService = placeService;
        this.cityService = cityService;
        this.modelMapper = modelMapper;
    }


    @GetMapping("/places/all")
    public String allPlaces(Model model) {
        model.addAttribute("places", placeService.getAllPlace());
        return "places";
    }

    @DeleteMapping("/places/{id}")
    public String deletePlace(@PathVariable Long id) {
        placeService.deletePlace(id);

        return "redirect:/places/all";
    }


    @GetMapping("/places/{id}/place-details")
    public String showPlace(@PathVariable Long id, Model model) {

        model.addAttribute("place", this.placeService.findById(id));
        return "place-details";
    }









}
