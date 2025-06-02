package com.duong.ss16.validate.hw01;


import com.duong.ss16.service.hw01.UserService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UniqueEmailImpl implements ConstraintValidator<UniqueEmail,String> {
    private final UserService userService;

    public UniqueEmailImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return userService.findByEmail(s).isEmpty();
    }
}
