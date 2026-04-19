package com.example.b4_s8.dto;

import com.example.b4_s8.validator.PasswordMatch;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@PasswordMatch(field = "password", fieldMatch = "confirmPassword")
public class RegisterDto {

    @NotBlank(message = "Username không được để trống")
    private String username;

    @NotBlank(message = "Password không được để trống")
    @Size(min = 6, message = "Password tối thiểu 6 ký tự")
    private String password;

    @NotBlank(message = "Confirm Password không được để trống")
    private String confirmPassword;

    // getters setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
