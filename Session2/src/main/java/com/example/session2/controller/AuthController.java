package com.example.session2.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(
            @RequestParam String username,
            @RequestParam String password,
            HttpSession session,
            Model model
    ) {
        if (username.equals("admin") && password.equals("admin123")) {
            session.setAttribute("loggedUser", username);
            session.setAttribute("role", "ADMIN");
            return "redirect:/orders";
        }

        if (username.equals("staff") && password.equals("staff123")) {
            session.setAttribute("loggedUser", username);
            session.setAttribute("role", "STAFF");
            return "redirect:/orders";
        }

        // request scope
        model.addAttribute("error", "Sai tài khoản hoặc mật khẩu");
        return "login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}