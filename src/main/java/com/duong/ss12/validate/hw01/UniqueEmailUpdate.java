package com.duong.ss12.validate.hw01;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = UniqueEmailUpdateImpl.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueEmailUpdate {
    String message () default "email already exists";
    Class<?>[] groups () default {};
    Class<? extends Payload>[] payload () default {};
}
