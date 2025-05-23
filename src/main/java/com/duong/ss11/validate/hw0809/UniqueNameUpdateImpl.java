package com.duong.ss11.validate.hw0809;

import com.duong.ss11.dto.hw0809.CategoryUpdateDTO;
import com.duong.ss11.model.Category;
import com.duong.ss11.service.hw0809.CategoryService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UniqueNameUpdateImpl implements ConstraintValidator<UniqueNameUpdate, CategoryUpdateDTO> {
    @Autowired
    private CategoryService categoryService;

    @Override
    public boolean isValid(CategoryUpdateDTO dto, ConstraintValidatorContext context) {
        if (dto == null || dto.getName() == null) {
            return true;
        }

        Optional<Category> existing = categoryService.findByName(dto.getName());
        return existing.map(category -> category.getId() == dto.getId()).orElse(true);

    }
}

