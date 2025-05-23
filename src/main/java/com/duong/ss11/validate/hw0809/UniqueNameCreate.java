package com.duong.ss11.validate.hw0809;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = UniqueNameCreateImpl.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueNameCreate {
    String message() default "Category name already exists";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}