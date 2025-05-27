package com.duong.ss12.validate.hw01;

import com.duong.ss12.dto.hw01.UpdateStudentDTO;
import com.duong.ss12.model.Student;
import com.duong.ss12.service.hw01.StudentService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Optional;

public class UniqueEmailUpdateImpl implements ConstraintValidator<UniqueEmailUpdate,UpdateStudentDTO> {
    private final StudentService studentService;

    public UniqueEmailUpdateImpl(StudentService studentService) {
        this.studentService = studentService;
    }

    @Override
    public boolean isValid(UpdateStudentDTO updateStudentDTO, ConstraintValidatorContext constraintValidatorContext) {
        if(updateStudentDTO == null || updateStudentDTO.getEmail() == null){
            return true;
        }

        Optional<Student> opt = studentService.findByEmail(updateStudentDTO.getEmail());
        return opt.map(std -> std.getId() == updateStudentDTO.getId()).orElse(true);
    }
}
