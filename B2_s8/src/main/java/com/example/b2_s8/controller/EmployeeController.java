package com.example.b2_s8.controller;

import com.example.b2_s8.dto.EmployeeDto;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/hr")
public class EmployeeController {

    @GetMapping("/add")
    public String showForm(Model model) {
        model.addAttribute("employee", new EmployeeDto());
        return "employee-form";
    }

    @PostMapping("/add-employee")
    public String saveEmployee(
            @Valid @ModelAttribute("employee") EmployeeDto employee,
            BindingResult bindingResult,
            Model model
    ) {

        if (bindingResult.hasErrors()) {
            return "employee-form";
        }

        return "redirect:/hr/success";
    }

    @GetMapping("/success")
    public String success() {
        return "success";
    }
}
