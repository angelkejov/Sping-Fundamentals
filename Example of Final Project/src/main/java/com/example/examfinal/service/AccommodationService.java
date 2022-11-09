package com.example.examfinal.service;

import com.example.examfinal.model.view.AccommodationDetailsView;
import com.example.examfinal.model.view.AccomodationViewModel;

import java.util.List;

public interface AccommodationService {
    List<AccomodationViewModel> getAllAccommodation();

    void initializeAccommodation();

    AccommodationDetailsView findById(Long id);
}
