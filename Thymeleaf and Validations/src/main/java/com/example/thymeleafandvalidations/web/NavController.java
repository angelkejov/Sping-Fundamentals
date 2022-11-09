package com.example.thymeleafandvalidations.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavController {

    @GetMapping("/companies/all")
    public String allCompanies() {

        return "company-all";
    }

    @GetMapping("/employees/add")
    public String addEmployees() {

        return "employee-add";
    }

    @GetMapping("/employees/all")
    public String allEmployees() {

        return "employee-all";
    }
}
