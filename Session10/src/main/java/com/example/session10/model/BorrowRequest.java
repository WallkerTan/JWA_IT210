package com.example.session10.model;

import java.time.LocalDate;

public class BorrowRequest {
    private Long id;
    private String studentName;
    private String studentCode;
    private String email;
    private int quantity;
    private LocalDate borrowDate;
    private LocalDate returnDate;
    private String reason;
    private Equipment equipment;

    public BorrowRequest() {
    }

    public BorrowRequest(Long id, String studentName, String studentCode, String email, int quantity,
                         LocalDate borrowDate, LocalDate returnDate, String reason, Equipment equipment) {
        this.id = id;
        this.studentName = studentName;
        this.studentCode = studentCode;
        this.email = email;
        this.quantity = quantity;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
        this.reason = reason;
        this.equipment = equipment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public java.time.LocalDate getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(java.time.LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }

    public java.time.LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(java.time.LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }
}
