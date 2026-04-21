package com.example.Session12.reponsotory;


import com.example.Session12.dto.DoctorDTO;
import com.example.Session12.model.Doctor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class DoctorReponsitory {
    private List<Doctor> doctors = new ArrayList<>(Arrays.asList(
            new Doctor(1,"tan1","0987654321","tam1@gmail.com","hanoi"),
            new Doctor(2,"tan2","0987654321","tam2@gmail.com","hanoi"),
            new Doctor(3,"tan3","0987654321","tam3@gmail.com","hanoi"),
            new Doctor(4,"tan4","0987654321","tam4@gmail.com","hanoi"),
            new Doctor(5,"tan5","0987654321","tam5@gmail.com","hanoi")
    ));

    public   List<Doctor> fildAll() {
        return new ArrayList<>(doctors);
    }

    public Doctor getDoctorById(int id){
        return doctors.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
    }
    public boolean deleteDoctor(int id){
        if(getDoctorById(id) == null){
            return false;
        }
        doctors.remove(getDoctorById(id));
        return true;
    }
    public boolean addDoctor(Doctor doctor){
        if(getDoctorById(doctor.getId()) == null){
            return false;
        }
        doctors.add(doctor);
        return true;
    }
    //chuyển sang dto
    public DoctorDTO changeDoctor(int id){
        Doctor doctor = getDoctorById(id);
        if(doctor == null){
            return null;
        }
        DoctorDTO doctorDTO = new DoctorDTO();
        doctorDTO.setId(doctor.getId());
        doctorDTO.setAddress(doctor.getAddress());
        doctorDTO.setEmail(doctor.getEmail());
        doctorDTO.setPhone(doctor.getPhone());
        doctorDTO.setName(doctor.getName());
        return doctorDTO;
    }

    public int findindex(int id){
        for(Doctor doctor : doctors){
            if(doctor.getId() == id){
                return doctors.indexOf(doctor);
            }
        }
        return -1;
    }
    public boolean updateDoctor(Doctor doctor){
        if(getDoctorById(doctor.getId()) == null){
            return false;
        }
        doctors.set(findindex(doctor.getId()), doctor);
        return true;
    }

}
