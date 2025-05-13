package com.duong.ss06.service.hw04;

import com.duong.ss06.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    List<Employee> getAllEmployees(String searchTerm);
    boolean addEmployee(Employee employee);
    boolean updateEmployee(Employee employee);
    boolean deleteEmployee(int id);
    Optional<Employee> getEmployeeById(int id);
}
