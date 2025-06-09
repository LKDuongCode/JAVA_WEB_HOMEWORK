package com.duong.ss20.validate;

import com.duong.ss20.service.SeedService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UniqueNameImpl implements ConstraintValidator<UniqueName,String> {
    private final SeedService seedService;

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return seedService.findByName(s).isEmpty();
    }
}
