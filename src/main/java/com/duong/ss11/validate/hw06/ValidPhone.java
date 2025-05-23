package com.duong.ss11.validate.hw06;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = {ValidPhoneImpl.class})
@Target({
        ElementType.ANNOTATION_TYPE,ElementType.FIELD,ElementType.METHOD
})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidPhone {
    String message () default "phone must be 10 numbers!";
    Class<?>[] groups () default {};
    Class<? extends Payload>[] payload () default {};
}
