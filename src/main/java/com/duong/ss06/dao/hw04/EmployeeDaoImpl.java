package com.duong.ss06.dao.hw04;

import com.duong.ss06.model.Employee;
import com.duong.ss06.utils.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EmployeeDaoImpl implements EmployeeDao {

    @Override
    public List<Employee> getAllEmployees(String searchTerm) {
        List<Employee> employees = new ArrayList<>();
        String sql = "{call sp_get_employees(?)}";

        try (Connection c = DatabaseConnection.connectToDatabase();
             CallableStatement call = c.prepareCall(sql)) {

            call.setString(1, searchTerm);

            try (ResultSet rs = call.executeQuery()) {
                while (rs.next()) {
                    employees.add(new Employee(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getDate("birthday"),
                            rs.getString("phone"),
                            rs.getString("email"),
                            rs.getBigDecimal("salary"),
                            rs.getString("position")
                    ));
                }
            }
        } catch (SQLException e) {
            System.err.println("Lỗi khi lấy danh sách nhân viên: " + e.getMessage());
        }

        return employees;
    }

    @Override
    public boolean addEmployee(Employee employee) {
        String sql = "{call sp_add_employee(?, ?, ?, ?, ?, ?)}";

        try (Connection c = DatabaseConnection.connectToDatabase();
             CallableStatement call = c.prepareCall(sql)) {

            call.setString(1, employee.getName());
            call.setDate(2, employee.getBirthday());
            call.setString(3, employee.getPhone());
            call.setString(4, employee.getEmail());
            call.setBigDecimal(5, employee.getSalary());
            call.setString(6, employee.getPosition());

            return call.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("Lỗi khi thêm nhân viên: " + e.getMessage());
        }

        return false;
    }

    @Override
    public boolean updateEmployee(Employee employee) {
        String sql = "{call sp_update_employee(?, ?, ?, ?, ?, ?, ?)}";

        try (Connection c = DatabaseConnection.connectToDatabase();
             CallableStatement call = c.prepareCall(sql)) {

            call.setInt(1, employee.getId());
            call.setString(2, employee.getName());
            call.setDate(3, employee.getBirthday());
            call.setString(4, employee.getPhone());
            call.setString(5, employee.getEmail());
            call.setBigDecimal(6, employee.getSalary());
            call.setString(7, employee.getPosition());

            return call.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("Lỗi khi cập nhật nhân viên: " + e.getMessage());
        }

        return false;
    }

    @Override
    public boolean deleteEmployee(int id) {
        String sql = "{call sp_delete_employee(?)}";

        try (Connection c = DatabaseConnection.connectToDatabase();
             CallableStatement call = c.prepareCall(sql)) {

            call.setInt(1, id);

            return call.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("Lỗi khi xóa nhân viên: " + e.getMessage());
        }

        return false;
    }

    @Override
    public Optional<Employee> getEmployeeById(int id) {
        String sql = "{call sp_get_employee_by_id(?)}";
        Employee employee = null;

        try (Connection c = DatabaseConnection.connectToDatabase();
             CallableStatement call = c.prepareCall(sql)) {

            call.setInt(1, id);

            try (ResultSet rs = call.executeQuery()) {
                if (rs.next()) {
                    employee = new Employee(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getDate("birthday"),
                            rs.getString("phone"),
                            rs.getString("email"),
                            rs.getBigDecimal("salary"),
                            rs.getString("position")
                    );
                }
            }

        } catch (SQLException e) {
            System.err.println("Lỗi khi lấy nhân viên theo id: " + e.getMessage());
        }

        return Optional.ofNullable(employee);
    }

}
