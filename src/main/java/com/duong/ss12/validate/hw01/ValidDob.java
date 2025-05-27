package com.duong.ss12.validate.hw01;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = ValidDobImpl.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidDob {
    String message () default "student must be 6 years of age or older!";
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
