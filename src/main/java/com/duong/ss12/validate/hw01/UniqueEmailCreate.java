package com.duong.ss12.validate.hw01;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = UniqueEmailCreateImpl.class)
@Target({
        ElementType.FIELD
})
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueEmailCreate {
    String message () default "email already exists";
    Class<?>[] groups () default {};
    Class<? extends Payload>[] payload () default {};
}
