package com.example.session10.service;

import com.example.session10.model.Equipment;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EquipmentService {

    private final List<Equipment> list = new ArrayList<>();

    public EquipmentService() {
        list.add(new Equipment(1L, "Màn hình rời", "https://npcshop.vn/media/product/2878-asus-rog-strix-xg17ahpe-173in-fhd-ips-240hz.jpeg", 5));
        list.add(new Equipment(2L, "Cáp HDMI", "https://cdn.hoanghamobile.vn/i/previewV2/Uploads/2023/05/10/cap-hdmi-to-hdmi-8k60hz-lention-hh21-m1-3m-2.png", 10));
        list.add(new Equipment(3L, "Board mạch", "https://achilles.com.vn/wp-content/uploads/2023/12/tong-quan-ve-bang-mach-in.jpg", 3));
        list.add(new Equipment(4L, "Phòng Lab A", "https://daiduongcorp.vn/wp-content/uploads/2021/05/Thiet-bi-phong-lab-3.jpg", 1));
    }

    public List<Equipment> findAll() {
        return list;
    }

    public Equipment findById(Long id) {
        if (id == null) return null;
        return list.stream().filter(e -> id.equals(e.getId())).findFirst().orElse(null);
    }
}
