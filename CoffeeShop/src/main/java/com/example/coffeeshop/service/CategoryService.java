package com.example.coffeeshop.service;

import com.example.coffeeshop.model.Category;
import com.example.coffeeshop.model.enums.TypeOfDrink;

public interface CategoryService {

    void initCategories();
    Category findByCategoryNameEnum(TypeOfDrink categoryNameEnum);
}
