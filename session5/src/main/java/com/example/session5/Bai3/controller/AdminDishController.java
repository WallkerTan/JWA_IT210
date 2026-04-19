package com.example.session5.Bai3.controller;

import com.example.session5.Bai2.Dish;
import com.example.session5.Bai3.service.AdminDishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/bai3")
public class AdminDishController {

    @Autowired
    private AdminDishService service;

    @GetMapping("/edit/{id}")
    public String editDish(@PathVariable int id, Model model, RedirectAttributes redirectAttributes) {

        Dish dish = service.findById(id);
        if (dish == null) {
            redirectAttributes.addFlashAttribute("message", "Không tìm thấy món ăn yêu cầu!");
            return "redirect:/bai2/dishes";
        }

        model.addAttribute("dish", dish);
        return "edit-dish";
    }
}
