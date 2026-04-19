package com.example.session5.controller;

import com.example.session5.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping
public class HomeController {
    List<Product> products = new ArrayList<>(
            Arrays.asList(
                    new Product(1, "Iphone 14 Pro Max", 30000000, 10, true),
                    new Product(2, "Samsung Galaxy S23 Ultra", 25000000, 15, true),
                    new Product(3, "Xiaomi Mi 12 Pro", 20000000, 20, true),
                    new Product(4, "Oppo Find X5 Pro", 22000000, 12, true),
                    new Product(5, "Vivo X80 Pro", 21000000, 18, true)
            )
    );

    @GetMapping
    public String home(Model model) {
        model.addAttribute("shop", products);
        return "home";
    }
//    @GetMapping("delete/{id}")
//    public String handleDelete(@PathVariable() int id, Model model) {
//    }
}
