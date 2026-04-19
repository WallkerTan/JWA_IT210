package com.example.b4_s8.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.lang.reflect.Field;
import java.util.Objects;

public class PasswordMatchValidator implements ConstraintValidator<PasswordMatch, Object> {

    private String field;
    private String fieldMatch;

    @Override
    public void initialize(PasswordMatch constraintAnnotation) {
        this.field = constraintAnnotation.field();
        this.fieldMatch = constraintAnnotation.fieldMatch();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {

        if (value == null) return true; // tránh crash

        try {
            Field fieldObj = value.getClass().getDeclaredField(field);
            Field fieldMatchObj = value.getClass().getDeclaredField(fieldMatch);

            fieldObj.setAccessible(true);
            fieldMatchObj.setAccessible(true);

            Object password = fieldObj.get(value);
            Object confirmPassword = fieldMatchObj.get(value);

            // xử lý null an toàn (KHÔNG dùng equals trực tiếp)
            boolean isValid = Objects.equals(password, confirmPassword);

            if (!isValid) {
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate("Password không khớp")
                        .addPropertyNode(fieldMatch)
                        .addConstraintViolation();
            }

            return isValid;

        } catch (Exception e) {
            return false;
        }
    }
}
