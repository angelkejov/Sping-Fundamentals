package com.softuni.exam.web;

import com.softuni.exam.model.binding.AddFoodBindingModel;
import com.softuni.exam.model.service.FoodServiceModel;
import com.softuni.exam.service.FoodService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/add")
public class FoodsController {

    private final FoodService foodService;
    private final ModelMapper modelMapper;

    public FoodsController(FoodService foodService, ModelMapper modelMapper) {
        this.foodService = foodService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/food")
    public String addFood(Model model) {
        if (!model.containsAttribute("addFoodBindingModel")) {
            model.addAttribute("addFoodBindingModel", new AddFoodBindingModel());
        }
        return "add_food";
    }


    @PostMapping("/food")
    public String addFoodConfirm(@Valid AddFoodBindingModel addFoodBindingModel,
                                 BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("addFoodBindingModel",
                    addFoodBindingModel);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.addFoodBindingModel",
                    bindingResult);
            return "redirect:food";
        }
        foodService.addFood(modelMapper.map(addFoodBindingModel, FoodServiceModel.class));
        return "redirect:shop";
    }
}
