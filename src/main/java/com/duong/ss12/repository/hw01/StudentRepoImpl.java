package com.duong.ss12.repository.hw01;

import com.duong.ss12.config.database.DatabaseConnection;
import com.duong.ss12.dto.hw01.CreateStudentDTO;
import com.duong.ss12.dto.hw01.UpdateStudentDTO;
import com.duong.ss12.model.Student;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class StudentRepoImpl implements StudentRepo {

    @Override
    public List<Student> getAll() {
        List<Student> students = new ArrayList<>();
        try (
                Connection c = DatabaseConnection.connection();
                CallableStatement call = c.prepareCall("{call sp_get_all_student () }")
        ) {
            try (ResultSet rs = call.executeQuery()) {
                while (rs.next()) {
                    students.add(extractResult(rs));
                }
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } catch (Exception e) {
            System.err.println("Lỗi bất định " + e.getMessage());
        }
        return students;
    }

    @Override
    public boolean insertStudent(CreateStudentDTO studentDTO) {
        try (
                Connection c = DatabaseConnection.connection();
                CallableStatement call = c.prepareCall("{call sp_insert_student (?,?,?)}")
        ) {
            call.setString(1, studentDTO.getName());
            call.setString(2, studentDTO.getEmail());
            call.setDate(3, Date.valueOf(studentDTO.getDob()));

            return call.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } catch (Exception e) {
            System.err.println("Lỗi bất định " + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean updateStudent(UpdateStudentDTO studentDTO) {
        try (
                Connection c = DatabaseConnection.connection();
                CallableStatement call = c.prepareCall("{call sp_update_student (?,?,?,?)}")
        ) {
            call.setInt(1, studentDTO.getId());
            call.setString(2, studentDTO.getName());
            call.setString(3, studentDTO.getEmail());
            call.setDate(4, Date.valueOf(studentDTO.getDob()));

            return call.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } catch (Exception e) {
            System.err.println("Lỗi bất định " + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean deleteStudent(int id) {
        try (
                Connection c = DatabaseConnection.connection();
                CallableStatement call = c.prepareCall("{call sp_delete_student (?)}")
        ) {
            call.setInt(1, id);

            return call.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } catch (Exception e) {
            System.err.println("Lỗi bất định " + e.getMessage());
        }
        return false;
    }

    @Override
    public Optional<Student> findById(int id) {
        try (
                Connection c = DatabaseConnection.connection();
                CallableStatement call = c.prepareCall("{call sp_find_student_by_id (?) }")
        ) {
            call.setInt(1,id);
            try (ResultSet rs = call.executeQuery()) {
                if (rs.next()) {
                    Student std  = extractResult(rs);
                    return Optional.of(std);
                }
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } catch (Exception e) {
            System.err.println("Lỗi bất định " + e.getMessage());
        }
        return Optional.empty();
    }

    private Student extractResult(ResultSet rs) throws SQLException {
        Student std = new Student();
        std.setId(rs.getInt("id"));
        std.setName(rs.getString("name"));
        std.setEmail(rs.getString("email"));
        std.setDob(rs.getDate("dob").toLocalDate());
        return std;
    }

    @Override
    public Optional<Student> findByEmail(String email) {
        try (
                Connection c = DatabaseConnection.connection();
                CallableStatement call = c.prepareCall("{call sp_find_student_by_email (?) }")
        ) {
            call.setString(1,email);

            try (ResultSet rs = call.executeQuery()) {
                if (rs.next()) {
                    Student std  = extractResult(rs);
                    return Optional.of(std);
                }
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } catch (Exception e) {
            System.err.println("Lỗi bất định " + e.getMessage());
        }
        return Optional.empty();
    }
}
