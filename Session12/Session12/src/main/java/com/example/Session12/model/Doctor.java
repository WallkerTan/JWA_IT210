package com.example.Session12.model;

import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
@Builder
public class Doctor {
    private int id;
    private String name;
    private String phone;
    private String email;
    private String address;
}
