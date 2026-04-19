package com.example.session10.dto;

import com.example.session10.validator.ValidBorrow;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

@ValidBorrow
public class BorrowRequestDTO {

    @NotBlank(message = "Họ tên sinh viên không được để trống")
    private String studentName;

    @NotBlank(message = "Mã sinh viên không được để trống")
    @Pattern(regexp = "^[A-Za-z]{2}\\d+$", message = "Mã sinh viên phải bắt đầu bằng 2 chữ cái và theo sau là các chữ số")
    private String studentCode;

    @NotBlank(message = "Email liên hệ không được để trống")
    @Email(message = "Email không đúng định dạng")
    private String email;

    @Min(value = 1, message = "Số lượng phải lớn hơn 0")
    private int quantity;

    @NotNull(message = "Ngày dự kiến nhận không được để trống")
    @Future(message = "Ngày dự kiến nhận phải là ngày trong tương lai")
    private LocalDate borrowDate;

    @NotNull(message = "Ngày dự kiến trả không được để trống")
    private LocalDate returnDate;

    @NotBlank(message = "Lý do mượn không được để trống")
    private String reason;

    @NotNull(message = "Thiết bị không hợp lệ")
    private Long equipmentId;

    public BorrowRequestDTO() {
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Long getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(Long equipmentId) {
        this.equipmentId = equipmentId;
    }
}
