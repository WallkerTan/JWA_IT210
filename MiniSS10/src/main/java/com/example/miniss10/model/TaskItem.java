package com.example.miniss10.model;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class TaskItem {

    private String id;

    @NotBlank(message = "Title không được để trống")
    @Size(min = 5, message = "Title phải có ít nhất 5 ký tự")
    private String title;

    @NotNull(message = "Deadline không được để trống")
    @Future(message = "Deadline phải là ngày trong tương lai")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate deadline;

    @NotNull(message = "Priority không được để trống")
    private Priority priority;

    public TaskItem() {
    }

    public TaskItem(String id, String title, LocalDate deadline, Priority priority) {
        this.id = id;
        this.title = title;
        this.deadline = deadline;
        this.priority = priority;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }
}
