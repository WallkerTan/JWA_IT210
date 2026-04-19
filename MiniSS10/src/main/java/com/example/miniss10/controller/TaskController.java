package com.example.miniss10.controller;

import com.example.miniss10.model.Priority;
import com.example.miniss10.model.TaskItem;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
public class TaskController {

    private final List<TaskItem> tasks = new ArrayList<>(List.of(
            new TaskItem("T001", "Fix lỗi đăng nhập", LocalDate.now().plusDays(3), Priority.HIGH),
            new TaskItem("T002", "Làm chức năng tạo bài viết", LocalDate.now().plusDays(5), Priority.MEDIUM),
            new TaskItem("T003", "Kiểm thử và rà soát lại", LocalDate.now().plusDays(7), Priority.LOW)
    ));

    @GetMapping("/tasks")
    public String showTaskList(Model model) {
        model.addAttribute("tasks", tasks);
        return "task-list";
    }

    @GetMapping("/tasks/new")
    public String showTaskForm(Model model) {
        model.addAttribute("taskItem", new TaskItem());
        model.addAttribute("priorities", Priority.values());
        return "task-form";
    }


    @PostMapping("/tasks")
    public String saveTask(
            @Valid @ModelAttribute("taskItem") TaskItem taskItem,
            BindingResult bindingResult,
            Model model
    ) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("priorities", Priority.values());
            return "task-form";
        }

        tasks.add(taskItem);
        return "redirect:/tasks";
    }
}

