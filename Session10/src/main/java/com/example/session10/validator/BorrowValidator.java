package com.example.session10.validator;

import com.example.session10.dto.BorrowRequestDTO;
import com.example.session10.model.Equipment;
import com.example.session10.service.EquipmentService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class BorrowValidator implements ConstraintValidator<ValidBorrow, BorrowRequestDTO> {

    @Autowired
    private EquipmentService equipmentService;

    @Override
    public boolean isValid(BorrowRequestDTO dto, ConstraintValidatorContext context) {
        if (dto == null) return true;

        boolean valid = true;
        context.disableDefaultConstraintViolation();

        if (dto.getBorrowDate() != null && dto.getReturnDate() != null
                && !dto.getReturnDate().isAfter(dto.getBorrowDate())) {
            context.buildConstraintViolationWithTemplate("Ngày dự kiến trả phải sau ngày dự kiến nhận")
                    .addPropertyNode("returnDate")
                    .addConstraintViolation();
            valid = false;
        }

        if (dto.getEquipmentId() != null) {
            Equipment eq = equipmentService.findById(dto.getEquipmentId());
            if (eq == null) {
                context.buildConstraintViolationWithTemplate("Thiết bị không tồn tại")
                        .addPropertyNode("equipmentId")
                        .addConstraintViolation();
                valid = false;
            } else if (dto.getQuantity() > eq.getQuantity()) {
                context.buildConstraintViolationWithTemplate("Số lượng mượn vượt quá số lượng tồn kho")
                        .addPropertyNode("quantity")
                        .addConstraintViolation();
                valid = false;
            }
        }

        return valid;
    }
}
