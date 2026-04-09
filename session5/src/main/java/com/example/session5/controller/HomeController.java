package com.example.session5.controller;

import com.example.session5.model.Product;
import com.example.session5.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping
public class HomeController {
    @Autowired
    private ProductService service;

    @GetMapping
    public String home(Model model) {
        List<Product> list = service.getProducts();
        model.addAttribute("products", list);
        return "home";
    }

}
