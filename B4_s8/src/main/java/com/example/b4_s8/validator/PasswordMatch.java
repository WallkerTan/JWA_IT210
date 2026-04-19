package com.example.b4_s8.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PasswordMatchValidator.class)
@Documented
public @interface PasswordMatch {

    String message() default "Password và Confirm Password không khớp";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    // cho phép tái sử dụng
    String field();

    String fieldMatch();
}
