package com.duong.ss12.validate.hw01;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class ValidDobImpl implements ConstraintValidator<ValidDob, LocalDate> {
    @Override
    public boolean isValid(LocalDate dob, ConstraintValidatorContext constraintValidatorContext) {
        if (dob == null) {
            return false;
        }
        if(dob.isAfter(LocalDate.now())) return false;
        return !dob.isAfter(LocalDate.now().minusYears(6));
    }
}
