package com.example.session10.controller;

import com.example.session10.service.BorrowService;
import com.example.session10.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private EquipmentService equipmentService;

    @Autowired
    private BorrowService borrowService;

    @GetMapping("/equipments")
    public String manageEquip(Model model) {
        model.addAttribute("list", equipmentService.findAll());
        return "admin/equipment";
    }

    @GetMapping("/requests")
    public String requests(Model model) {
        model.addAttribute("list", borrowService.findAll());
        return "admin/request";
    }
}
