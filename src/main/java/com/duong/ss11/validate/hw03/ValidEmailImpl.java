package com.duong.ss11.validate.hw03;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Pattern;

public class ValidEmailImpl implements ConstraintValidator<ValidEmail,String> {
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        String regex = "^[a-zA-Z0-9]+@gmail\\.com$";
        if(Pattern.matches(regex,s)){
            return true;
        }
        return false;
    }
}
