package com.duong.ss11.validate.hw04;

import com.duong.ss11.validate.hw03.ValidEmailImpl;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = ValidPasswordImpl.class)
@Target({
        ElementType.FIELD,
        ElementType.METHOD,
        ElementType.ANNOTATION_TYPE
})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidPassword {
    String message ()default "password must be 6 characters or more and include 1 special character, one letter and one number";
    Class<?>[] groups () default {};
    Class<? extends Payload> [] payload () default {};
}
