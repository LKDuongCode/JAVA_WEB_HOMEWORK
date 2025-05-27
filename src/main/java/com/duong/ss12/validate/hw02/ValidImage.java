package com.duong.ss12.validate.hw02;

import com.duong.ss12.validate.hw01.ValidFormatEmailImpl;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = ValidImageImpl.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidImage {
    String message () default "image is invalid!";
    Class<?>[] groups () default {};
    Class<? extends Payload>[] payload () default {};
}
