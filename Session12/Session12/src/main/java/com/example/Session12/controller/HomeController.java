package com.example.Session12.controller;


import com.example.Session12.dto.DoctorDTO;
import com.example.Session12.service.DoctorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping
@RequiredArgsConstructor
public class HomeController {
    private final DoctorService Service;

    @GetMapping
    public String home(Model model) {
        model.addAttribute("doctors", Service.fildAll());
        return "home";
    }

    @GetMapping("/doctor/delete/{id}")
    public String deleteDoctor(@PathVariable Integer id) {
        Service.deleteDoctor(id);
        return "redirect:/";
    }

    @GetMapping("/doctor/deltail/{id}")
    public String deltail(@PathVariable("id") Integer id,Model model) {
        model.addAttribute("DTO", Service.changeDoctor(id));
        return "deltail";
    }

    @PostMapping("/doctor/deltail/{id}")
    public String deltail(@Valid @ModelAttribute DoctorDTO doctorDTO, @PathVariable("id") Integer id, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()){
            model.addAttribute("DTO", Service.changeDoctor(id));
            return "deltail";
        }
        Service.updateDoctor(doctorDTO);
        return "redirect:/";
    }
}
