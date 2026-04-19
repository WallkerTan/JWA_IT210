package com.example.session7.Bai4;

import com.example.session7.Bai3.Food;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.util.*;

@Controller
@RequestMapping("/food")
public class FoodController {

    public static final List<Food> foodList = new ArrayList<>();

    @PostMapping("/add")
    public String addFood(
            @RequestParam String name,
            @RequestParam String category,
            @RequestParam double price,
            @RequestParam("image") MultipartFile file,
            RedirectAttributes redirectAttributes
    ) {

        // 1. Validate file
        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("error", "Chưa chọn ảnh");
            return "redirect:/food/add";
        }

        // 2. Validate size (backup nếu config fail)
        if (file.getSize() > 2 * 1024 * 1024) {
            redirectAttributes.addFlashAttribute("error", "File vượt quá 2MB");
            return "redirect:/food/add";
        }

        // 3. Validate extension
        String originalName = file.getOriginalFilename();
        if (originalName == null ||
                !(originalName.endsWith(".jpg") ||
                        originalName.endsWith(".jpeg") ||
                        originalName.endsWith(".png"))) {

            redirectAttributes.addFlashAttribute("error", "Chỉ nhận jpg, jpeg, png");
            return "redirect:/food/add";
        }

        // 4. Validate price
        if (price < 0) {
            redirectAttributes.addFlashAttribute("error", "Giá phải >= 0");
            return "redirect:/food/add";
        }

        try {
            String uploadDir = "C:/RikkeiFood_Temp/";
            File dir = new File(uploadDir);
            if (!dir.exists()) dir.mkdirs();

            // 🔥 Sinh tên file unique (timestamp + original)
            String newFileName = System.currentTimeMillis() + "_" + originalName;

            File destination = new File(uploadDir + newFileName);
            file.transferTo(destination);

            // tạo object
            Food food = new Food(name, category, price, destination.getAbsolutePath());

            foodList.add(food);

            int index = foodList.size() - 1;

            // log
            System.out.println("✅ Đã thêm: " + name);
            System.out.println("👉 Tổng món: " + foodList.size());

            // redirect sang detail
            redirectAttributes.addFlashAttribute("success", "Thêm món thành công");

            return "redirect:/food/detail?id=" + index;

        } catch (Exception e) {
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("error", "Upload thất bại");
            return "redirect:/food/add";
        }
    }

    // Trang chi tiết
    @GetMapping("/detail")
    public String foodDetail(@RequestParam("id") int id, Map<String, Object> model) {

        if (id < 0 || id >= foodList.size()) {
            model.put("error", "Không tìm thấy món");
            return "error";
        }

        model.put("food", foodList.get(id));
        return "food-detail";
    }
}
