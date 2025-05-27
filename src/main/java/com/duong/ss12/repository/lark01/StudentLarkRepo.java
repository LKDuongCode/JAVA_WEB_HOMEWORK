package com.duong.ss12.repository.lark01;

import com.duong.ss12.dto.lark01.CreateStudentLarkDTO;
import com.duong.ss12.dto.lark01.UpdateStudentLarkDTO;
import com.duong.ss12.model.StudentLark;

import java.util.List;
import java.util.Optional;

public interface StudentLarkRepo {
    List<StudentLark> getAll();
    boolean insertStudent(CreateStudentLarkDTO dto);
    boolean updateStudent(UpdateStudentLarkDTO dto);
    boolean deleteStudent(String id);
    Optional<StudentLark> findById(String id);
    Optional<StudentLark> findByEmail(String email);
    Optional<StudentLark> findByPhone(String phone);
    List<StudentLark> findByNameLike(String keyword);
}
