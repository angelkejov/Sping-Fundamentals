package com.likebookapp.controller;

import com.likebookapp.model.entity.binding.UserRegistrationBindingModel;
import com.likebookapp.model.entity.service.UserServiceModel;
import com.likebookapp.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserRegistrationController {

    private final UserService userService;
    private final ModelMapper modelMapper;

    public UserRegistrationController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/register")
    public String register() {

        return "register";
    }

    @PostMapping("/register")
    public String registerConfirm(@Valid UserRegistrationBindingModel userRegistrationBindingModel,
                                  BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors() || !userRegistrationBindingModel.getPassword()
                .equals(userRegistrationBindingModel.getConfirmPassword())) {

            redirectAttributes.addFlashAttribute("userRegistrationBindingModel", userRegistrationBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userRegistrationBindingModel", bindingResult);

            return "redirect:register";
        }

        //save in DB
        userService.registerUser(modelMapper
                .map(userRegistrationBindingModel, UserServiceModel.class));

        return "redirect:login";
    }

    @ModelAttribute
    public UserRegistrationBindingModel userRegisterBindingModel(){
        return new UserRegistrationBindingModel();
    }
}
