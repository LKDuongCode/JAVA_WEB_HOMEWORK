package com.duong.ss11.validate.hw06;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Pattern;

public class ValidPhoneImpl implements ConstraintValidator<ValidPhone,String> {
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        String regex = "^0[3789][0-9]{8}$";
        if(Pattern.matches(regex,s)) return true;
        return false;
    }
}
