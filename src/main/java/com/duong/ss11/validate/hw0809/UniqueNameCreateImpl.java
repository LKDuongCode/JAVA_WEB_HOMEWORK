package com.duong.ss11.validate.hw0809;

import com.duong.ss11.service.hw0809.CategoryService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UniqueNameCreateImpl implements ConstraintValidator<UniqueNameCreate, String> {

    @Autowired
    private CategoryService categoryService;

    @Override
    public boolean isValid(String name, ConstraintValidatorContext context) {
        return name != null && categoryService.findByName(name).isEmpty();
    }
}
