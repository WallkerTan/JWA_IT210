package com.example.b1_s8.controller;

import com.example.b1_s8.dto.AddressDto;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/address")
public class UserController {

    @GetMapping
    public String showForm(Model model) {
        model.addAttribute("addressDto", new AddressDto());
        return "form";
    }

    @PostMapping("/update")
    public String update(
            @Valid @ModelAttribute("addressDto") AddressDto dto,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            return "form";
        }

        return "success";
    }
}
