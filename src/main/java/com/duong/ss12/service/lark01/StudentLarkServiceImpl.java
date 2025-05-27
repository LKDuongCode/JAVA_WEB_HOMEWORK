package com.duong.ss12.service.lark01;

import com.duong.ss12.dto.lark01.CreateStudentLarkDTO;
import com.duong.ss12.dto.lark01.UpdateStudentLarkDTO;
import com.duong.ss12.model.StudentLark;
import com.duong.ss12.repository.lark01.StudentLarkRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentLarkServiceImpl implements StudentLarkService {

    private final StudentLarkRepo studentLarkRepo;

    public StudentLarkServiceImpl(StudentLarkRepo studentLarkRepo) {
        this.studentLarkRepo = studentLarkRepo;
    }

    @Override
    public List<StudentLark> getAll() {
        return studentLarkRepo.getAll();
    }

    @Override
    public boolean insertStudent(CreateStudentLarkDTO dto) {
        return studentLarkRepo.insertStudent(dto);
    }

    @Override
    public boolean updateStudent(UpdateStudentLarkDTO dto) {
        return studentLarkRepo.updateStudent(dto);
    }

    @Override
    public boolean deleteStudent(String id) {
        return studentLarkRepo.deleteStudent(id);
    }

    @Override
    public Optional<StudentLark> findById(String id) {
        return studentLarkRepo.findById(id);
    }

    @Override
    public Optional<StudentLark> findByEmail(String email) {
        return studentLarkRepo.findByEmail(email);
    }

    @Override
    public Optional<StudentLark> findByPhone(String phone) {
        return studentLarkRepo.findByPhone(phone);
    }

    @Override
    public List<StudentLark> findByNameLike(String keyword) {
        return studentLarkRepo.findByNameLike(keyword);
    }
}
