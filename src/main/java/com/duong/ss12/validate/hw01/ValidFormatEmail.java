package com.duong.ss12.validate.hw01;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = ValidFormatEmailImpl.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidFormatEmail {
    String message () default "email must be in the format example@gmail.com!";
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
