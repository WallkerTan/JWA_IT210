package com.example.Session12.service;


import com.example.Session12.dto.DoctorDTO;
import com.example.Session12.model.Doctor;
import com.example.Session12.reponsotory.DoctorReponsitory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorService {
    private final DoctorReponsitory doctorReponsitory;

    public List<Doctor> fildAll() {
        return  doctorReponsitory.fildAll();
    }
    public Doctor fildByDoctorId(int id) {
        return doctorReponsitory.getDoctorById(id);
    }
    public boolean deleteDoctor(int id) {
        return doctorReponsitory.deleteDoctor(id);
    }
    public boolean addDoctor(DoctorDTO doctorDTO) {
        return doctorReponsitory.addDoctor(reChange(doctorDTO,1));
    }
    public DoctorDTO changeDoctor(int id) {
        return doctorReponsitory.changeDoctor(id);
    }

    public Doctor reChange(DoctorDTO doctorDTO,int type) {
        if(type == 1){
            Doctor optional = doctorReponsitory.fildAll().stream().max(Comparator.comparingInt(Doctor::getId)).orElse(null);
            Doctor doctor = Doctor.builder().id(optional==null?1:optional.getId()+1).email(doctorDTO.getEmail()).name(doctorDTO.getName()).phone(doctorDTO.getPhone()).build();
            return doctor;
        }
        Doctor doctor = Doctor.builder().id(doctorDTO.getId()).email(doctorDTO.getEmail()).name(doctorDTO.getName()).phone(doctorDTO.getPhone()).build();
        return doctor;
    }

    public boolean updateDoctor(DoctorDTO doctorDTO) {
        return doctorReponsitory.updateDoctor(reChange(doctorDTO,2));
    }

}
