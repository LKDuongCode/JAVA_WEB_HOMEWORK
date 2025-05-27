package com.duong.ss12.service.hw01;

import com.duong.ss12.dto.hw01.CreateStudentDTO;
import com.duong.ss12.dto.hw01.UpdateStudentDTO;
import com.duong.ss12.model.Student;
import com.duong.ss12.repository.hw01.StudentRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{
    private final StudentRepo studentRepo;

    public StudentServiceImpl(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    @Override
    public List<Student> getAll() {
        return studentRepo.getAll();
    }

    @Override
    public boolean insertStudent(CreateStudentDTO studentDTO) {
        return studentRepo.insertStudent(studentDTO);
    }

    @Override
    public boolean updateStudent(UpdateStudentDTO studentDTO) {
        return studentRepo.updateStudent(studentDTO);
    }

    @Override
    public boolean deleteStudent(int id) {
        return studentRepo.deleteStudent(id);
    }

    @Override
    public Optional<Student> findById(int id) {
        return studentRepo.findById(id);
    }

    @Override
    public Optional<Student> findByEmail(String email) {
        return studentRepo.findByEmail(email);
    }
}
