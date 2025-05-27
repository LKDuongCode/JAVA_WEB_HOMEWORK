package com.duong.ss12.repository.lark01;

import com.duong.ss12.config.database.DatabaseConnection;
import com.duong.ss12.dto.lark01.CreateStudentLarkDTO;
import com.duong.ss12.dto.lark01.UpdateStudentLarkDTO;
import com.duong.ss12.model.Sex;
import com.duong.ss12.model.StudentLark;
import com.duong.ss12.model.StudentStatus;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class StudentLarkRepoImpl implements StudentLarkRepo {

    private StudentLark extractResult(ResultSet rs) throws SQLException {
        StudentLark s = new StudentLark();
        s.setId(rs.getString("id"));
        s.setName(rs.getString("name"));
        s.setEmail(rs.getString("email"));
        s.setPhone(rs.getString("phone"));
        s.setSex(Sex.valueOf(rs.getString("sex")));
        s.setBod(rs.getTimestamp("bod").toLocalDateTime());
        s.setAvatar(rs.getString("avatar"));
        s.setStatus(StudentStatus.valueOf(rs.getString("status")));
        return s;
    }

    @Override
    public List<StudentLark> getAll() {
        List<StudentLark> list = new ArrayList<>();
        try (
                Connection c = DatabaseConnection.connection();
                CallableStatement call = c.prepareCall("{call sp_get_all_student_lark()}")
        ) {
            ResultSet rs = call.executeQuery();
            while (rs.next()) list.add(extractResult(rs));
        } catch (Exception e) {
            System.err.println("getAll error: " + e.getMessage());
        }
        return list;
    }

    @Override
    public boolean insertStudent(CreateStudentLarkDTO dto) {
        try (
                Connection c = DatabaseConnection.connection();
                CallableStatement call = c.prepareCall("{call sp_insert_student_lark(?,?,?,?,?,?,?,?)}")
        ) {
            call.setString(1, dto.getId());
            call.setString(2, dto.getName());
            call.setString(3, dto.getEmail());
            call.setString(4, dto.getPhone());
            call.setString(5, dto.getSex().name());
            call.setTimestamp(6, Timestamp.valueOf(dto.getBod()));
            call.setString(7, dto.getAvatar());
            call.setString(8, dto.getStatus().name());

            return call.executeUpdate() > 0;
        } catch (Exception e) {
            System.err.println("insert error: " + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean updateStudent(UpdateStudentLarkDTO dto) {
        try (
                Connection c = DatabaseConnection.connection();
                CallableStatement call = c.prepareCall("{call sp_update_student_lark(?,?,?,?,?,?,?,?)}")
        ) {
            call.setString(1, dto.getId());
            call.setString(2, dto.getName());
            call.setString(3, dto.getEmail());
            call.setString(4, dto.getPhone());
            call.setString(5, dto.getSex().name());
            call.setTimestamp(6, Timestamp.valueOf(dto.getBod()));
            call.setString(7, dto.getAvatar());
            call.setString(8, dto.getStatus().name());

            return call.executeUpdate() > 0;
        } catch (Exception e) {
            System.err.println("update error: " + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean deleteStudent(String id) {
        try (
                Connection c = DatabaseConnection.connection();
                CallableStatement call = c.prepareCall("{call sp_delete_student_lark(?)}")
        ) {
            call.setString(1, id);
            return call.executeUpdate() > 0;
        } catch (Exception e) {
            System.err.println("delete error: " + e.getMessage());
        }
        return false;
    }

    @Override
    public Optional<StudentLark> findById(String id) {
        try (
                Connection c = DatabaseConnection.connection();
                CallableStatement call = c.prepareCall("{call sp_find_student_lark_by_id(?)}")
        ) {
            call.setString(1, id);
            ResultSet rs = call.executeQuery();
            if (rs.next()) return Optional.of(extractResult(rs));
        } catch (Exception e) {
            System.err.println("findById error: " + e.getMessage());
        }
        return Optional.empty();
    }

    @Override
    public Optional<StudentLark> findByEmail(String email) {
        try (
                Connection c = DatabaseConnection.connection();
                CallableStatement call = c.prepareCall("{call sp_find_student_lark_by_email(?)}")
        ) {
            call.setString(1, email);
            ResultSet rs = call.executeQuery();
            if (rs.next()) return Optional.of(extractResult(rs));
        } catch (Exception e) {
            System.err.println("findByEmail error: " + e.getMessage());
        }
        return Optional.empty();
    }

    @Override
    public Optional<StudentLark> findByPhone(String phone) {
        try (
                Connection c = DatabaseConnection.connection();
                CallableStatement call = c.prepareCall("{call sp_find_student_lark_by_phone(?)}")
        ) {
            call.setString(1, phone);
            ResultSet rs = call.executeQuery();
            if (rs.next()) return Optional.of(extractResult(rs));
        } catch (Exception e) {
            System.err.println("findByPhone error: " + e.getMessage());
        }
        return Optional.empty();
    }

    @Override
    public List<StudentLark> findByNameLike(String keyword) {
        List<StudentLark> list = new ArrayList<>();
        try (
                Connection c = DatabaseConnection.connection();
                CallableStatement call = c.prepareCall("{call sp_find_student_lark_by_name_like(?)}")
        ) {
            call.setString(1, keyword);
            ResultSet rs = call.executeQuery();
            while (rs.next()) list.add(extractResult(rs));
        } catch (Exception e) {
            System.err.println("findByNameLike error: " + e.getMessage());
        }
        return list;
    }
}
