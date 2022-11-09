package com.example.examfinal.web;

import com.example.examfinal.service.AccommodationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class AccomodationController {
    private final AccommodationService accommodationService;

    public AccomodationController(AccommodationService accommodationService) {
        this.accommodationService = accommodationService;
    }


    @GetMapping("/accommodation/all")
    public String allPlaces(Model model) {
        model.addAttribute("accommodation", accommodationService.getAllAccommodation());
        return "accommodation";
    }
    @GetMapping("/accommodation/{id}/accommodation-details")
    public String showPlace(@PathVariable Long id, Model model) {

        model.addAttribute("accommodation", this.accommodationService.findById(id));
        return "accommodation-details";
    }
}
