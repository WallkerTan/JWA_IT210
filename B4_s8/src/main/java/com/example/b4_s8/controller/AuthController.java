package com.example.b4_s8.controller;

import com.example.b4_s8.dto.RegisterDto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @PostMapping("/register")
    public ResponseEntity<String> register(@Valid @RequestBody RegisterDto dto) {
        return ResponseEntity.ok("Đăng ký thành công");
    }
}
