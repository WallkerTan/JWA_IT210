package com.example.session5.Bai3.service;

import com.example.session5.Bai2.Dish;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminDishService {

    private List<Dish> dishes = new ArrayList<>();

    public AdminDishService() {
        dishes.add(new Dish(1, "Phở bò", 50000, true));
        dishes.add(new Dish(2, "Bún chả", 45000, false));
        dishes.add(new Dish(3, "Cơm rang", 40000, true));
    }

    public Dish findById(int id) {
        return dishes.stream()
                .filter(d -> d.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public List<Dish> getAll() {
        return dishes;
    }
}
