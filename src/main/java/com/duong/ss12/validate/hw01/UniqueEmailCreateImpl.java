package com.duong.ss12.validate.hw01;

import com.duong.ss12.model.Student;
import com.duong.ss12.service.hw01.StudentService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UniqueEmailCreateImpl implements ConstraintValidator<UniqueEmailCreate,String> {
    private final StudentService studentService;

    public UniqueEmailCreateImpl(StudentService studentService) {
        this.studentService = studentService;
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (s == null) {
            return false;
        }
        Optional<Student> std = studentService.findByEmail(s);
        return std.isEmpty();
    }
}
