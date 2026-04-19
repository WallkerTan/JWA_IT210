package com.example.session10.service;

import com.example.session10.dto.BorrowRequestDTO;
import com.example.session10.model.BorrowRequest;
import com.example.session10.model.Equipment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BorrowService {

    private final List<BorrowRequest> list = new ArrayList<>();

    @Autowired
    private EquipmentService equipmentService;

    public void save(BorrowRequestDTO dto) {
        BorrowRequest b = new BorrowRequest();
        b.setId((long) (list.size() + 1));
        b.setStudentName(dto.getStudentName());
        b.setStudentCode(dto.getStudentCode());
        b.setEmail(dto.getEmail());
        b.setQuantity(dto.getQuantity());
        b.setBorrowDate(dto.getBorrowDate());
        b.setReturnDate(dto.getReturnDate());
        b.setReason(dto.getReason());

        Equipment eq = equipmentService.findById(dto.getEquipmentId());
        b.setEquipment(eq);

        list.add(b);
    }

    public List<BorrowRequest> findAll() {
        return list;
    }
}
