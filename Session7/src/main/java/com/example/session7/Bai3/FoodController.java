package com.example.session7.Bai3;

import com.example.session7.Bai3.Food;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/food")
public class FoodController {

    private static final List<Food> foodList = new ArrayList<>();

    @PostMapping("/add")
    public String addFood(
            @RequestParam("name") String name,
            @RequestParam("category") String category,
            @RequestParam("price") double price,
            @RequestParam("image") MultipartFile file
    ) {

        // 1. Check file empty
        if (file.isEmpty()) {
            System.out.println("❌ Lỗi: Chưa chọn ảnh");
            return "error";
        }

        // 2. Check định dạng file
        String fileName = file.getOriginalFilename();
        if (fileName == null ||
                !(fileName.endsWith(".jpg") ||
                        fileName.endsWith(".jpeg") ||
                        fileName.endsWith(".png"))) {

            System.out.println("❌ Lỗi: File không hợp lệ (chỉ nhận jpg, jpeg, png)");
            return "error";
        }

        // 3. Check price
        if (price < 0) {
            System.out.println("❌ Lỗi: Giá phải >= 0");
            return "error";
        }

        try {
            // 4. Lưu file
            String uploadDir = "C:/RikkeiFood_Temp/";
            File dir = new File(uploadDir);
            if (!dir.exists()) {
                dir.mkdirs();
            }

            String filePath = uploadDir + fileName;
            file.transferTo(new File(filePath));

            // 5. Tạo object
            Food food = new Food(name, category, price, filePath);

            // 6. Lưu vào list
            foodList.add(food);

            // 7. Log
            System.out.println("✅ Đã thêm món:");
            System.out.println("Tên: " + name);
            System.out.println("Danh mục: " + category);
            System.out.println("Giá: " + price);
            System.out.println("Ảnh: " + filePath);
            System.out.println("👉 Tổng số món: " + foodList.size());

        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }

        return "success";
    }
}
