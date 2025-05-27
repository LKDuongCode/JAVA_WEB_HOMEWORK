package com.duong.ss12.validate.hw01;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
public class ValidFormatEmailImpl implements ConstraintValidator<ValidFormatEmail,String> {
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        String regex = "^[a-zA-z0-9]+@gmail\\.com$";
        if (s == null) {
            return false;
        }
        return Pattern.matches(regex, s);
    }
}
