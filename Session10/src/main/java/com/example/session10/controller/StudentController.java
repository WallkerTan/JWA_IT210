package com.example.session10.controller;

import com.example.session10.dto.BorrowRequestDTO;
import com.example.session10.service.BorrowService;
import com.example.session10.service.EquipmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private EquipmentService equipmentService;

    @Autowired
    private BorrowService borrowService;

    @GetMapping("/equipments")
    public String list(Model model) {
        model.addAttribute("equipments", equipmentService.findAll());
        return "student/list";
    }

    @GetMapping("/borrow/{id}")
    public String form(@PathVariable("id") Long equipmentId, Model model) {
        BorrowRequestDTO dto = new BorrowRequestDTO();
        dto.setEquipmentId(equipmentId);

        model.addAttribute("borrow", dto);
        model.addAttribute("equipment", equipmentService.findById(equipmentId));
        return "student/form";
    }


    @PostMapping("/borrow")
    public String submit(
            @Valid @ModelAttribute("borrow") BorrowRequestDTO dto,
            BindingResult result,
            RedirectAttributes redirectAttributes,
            Model model
    ) {
        if (result.hasErrors()) {
            model.addAttribute("equipment", equipmentService.findById(dto.getEquipmentId()));
            return "student/form";
        }

        borrowService.save(dto);
        redirectAttributes.addFlashAttribute("success", "Đăng ký thành công");
        return "redirect:/student/equipments";
    }
}
