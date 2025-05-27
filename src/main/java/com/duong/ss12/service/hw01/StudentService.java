package com.duong.ss12.service.hw01;


import com.duong.ss12.dto.hw01.CreateStudentDTO;
import com.duong.ss12.dto.hw01.UpdateStudentDTO;
import com.duong.ss12.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    List<Student> getAll ();
    boolean insertStudent (CreateStudentDTO studentDTO);
    boolean updateStudent (UpdateStudentDTO studentDTO);
    boolean deleteStudent (int id);
    Optional<Student> findById (int id);
    Optional<Student> findByEmail (String email);
}
