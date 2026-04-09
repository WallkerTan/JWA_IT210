package com.example.session2.controller;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;

@Controller
public class OrderController {

    @GetMapping("/orders")
    public String orders(
            HttpSession session,
            ServletContext application,
            Model model
    ) {

        // check login
        if (session.getAttribute("loggedUser") == null) {
            return "redirect:/login";
        }

        // fake data
        List<Map<String, Object>> orders = new ArrayList<>();

        orders.add(createOrder("OD01", "Laptop", 15000000, new Date()));
        orders.add(createOrder("OD02", "Mouse", 200000, new Date()));
        orders.add(createOrder("OD03", "Keyboard", 500000, new Date()));

        model.addAttribute("orders", orders);

        // ===== FIX RACE CONDITION =====
        synchronized (application) {
            Integer count = (Integer) application.getAttribute("totalViewCount");
            if (count == null) count = 0;
            application.setAttribute("totalViewCount", count + 1);
        }

        return "orders";
    }

    private Map<String, Object> createOrder(String id, String name, int price, Date date) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("name", name);
        map.put("price", price);
        map.put("date", date);
        return map;
    }
}