package com.example.thymeleafandvalidations.web;

import com.example.thymeleafandvalidations.model.dto.CompanyDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class CompanyController {

    @GetMapping("/companies/add")
    public String addCompany() {

        return "company-add";
    }

    @PostMapping("/companies/add")
    public String register(@Valid CompanyDTO companyDTO,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("company", companyDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.Company",
                    bindingResult);
            return "redirect:/companies/add";
        }

        return "redirect:/";
    }
}
