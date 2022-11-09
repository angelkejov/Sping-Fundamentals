package com.likebookapp.controller;

import com.likebookapp.model.entity.binding.UserLoginBindingModel;
import com.likebookapp.model.entity.binding.UserRegistrationBindingModel;
import com.likebookapp.model.entity.service.UserServiceModel;
import com.likebookapp.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserLoginController {

    private final UserService userService;
    private final ModelMapper modelMapper;

    public UserLoginController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/login")
    public String login(Model model)   {
        if(!model.containsAttribute("isFound")){
            model.addAttribute("isFound", true);
        }
        return "login";
    }

    @PostMapping("/login")
    public String loginConfirm(@Valid UserLoginBindingModel userLoginBindingModel
            , BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("userLoginBindingModel", userLoginBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userLoginBindingModel", bindingResult);

            return "redirect:login";
        }
        UserServiceModel userServiceModel = userService
                .findByUsernameAndPassword(userLoginBindingModel.getUsername()
                        , userLoginBindingModel.getPassword());


        if(userServiceModel == null){
            redirectAttributes.addFlashAttribute("userLoginBindingModel", userLoginBindingModel);
            redirectAttributes.addFlashAttribute("isFound", false);

            return "redirect:login";
        }


        userService.loginUser(userServiceModel.getId(), userLoginBindingModel.getUsername());

        return "redirect:/home";
    }
    @GetMapping("/logout")
    public String logout(HttpSession httpSession){
        httpSession.invalidate();

        return "redirect:/";
    }

    @ModelAttribute
    public UserLoginBindingModel userRegisterBindingModel(){
        return new UserLoginBindingModel();
    }
}
