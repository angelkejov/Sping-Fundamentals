package com.example.examfinal.service;

import com.example.examfinal.model.view.PlaceDetailsViewModel;
import com.example.examfinal.model.view.PlaceViewModel;

import java.util.List;

public interface PlaceService {
    List<PlaceViewModel> getAllPlace();

    void initializePlace();

    PlaceDetailsViewModel findById(Long id);

    void deletePlace(Long id);

}
