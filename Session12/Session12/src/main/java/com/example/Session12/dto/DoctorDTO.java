package com.example.Session12.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
@Builder
public class DoctorDTO {
    private int id;
    @NotBlank(message = "tên của m không nhớ đươc à")
    private String name;
    @Pattern(regexp = "^0[3579][0-9]{8}$", message = "sdt khong hop le")
    private String phone;
    @Pattern(regexp = "^[A-Za-z0-9+-_.]+@(.+)$", message = "email khong hơp le")
    private String email;
    @NotBlank(message = "dia chi khong duoc bo trong")
    private String address;
}
