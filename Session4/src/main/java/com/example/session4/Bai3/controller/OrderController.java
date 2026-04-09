package com.example.session4.Bai3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/bai3")
public class OrderController {

    @GetMapping("/orders/{id}")
    @ResponseBody
    public String getOrderById(@PathVariable("id") Long id) {
        return "Chi tiet don hang so " + id;
    }
}