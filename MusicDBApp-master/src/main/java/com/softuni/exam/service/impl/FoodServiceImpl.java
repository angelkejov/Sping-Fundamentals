package com.softuni.exam.service.impl;

import com.softuni.exam.model.entity.Food;
import com.softuni.exam.model.service.FoodServiceModel;
import com.softuni.exam.repos.FoodRepository;
import com.softuni.exam.service.FoodService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class FoodServiceImpl implements FoodService {

    private final FoodRepository foodRepository;
    private final ModelMapper modelMapper;

    public FoodServiceImpl(FoodRepository foodRepository, ModelMapper modelMapper) {
        this.foodRepository = foodRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void addFood(FoodServiceModel foodServiceModel) {
        foodRepository.save(modelMapper.map(foodServiceModel, Food.class));
    }
}
