package com.duong.ss06.service.hw04;

import com.duong.ss06.dao.hw04.EmployeeDao;
import com.duong.ss06.dao.hw04.EmployeeDaoImpl;
import com.duong.ss06.model.Employee;

import java.util.List;
import java.util.Optional;

public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeDao employeeDao = new EmployeeDaoImpl();

    @Override
    public List<Employee> getAllEmployees(String searchTerm) {
        return employeeDao.getAllEmployees(searchTerm);
    }

    @Override
    public boolean addEmployee(Employee employee) {
        return employeeDao.addEmployee(employee);
    }

    @Override
    public boolean updateEmployee(Employee employee) {
        return employeeDao.updateEmployee(employee);
    }

    @Override
    public boolean deleteEmployee(int id) {
        return employeeDao.deleteEmployee(id);
    }

    @Override
    public Optional<Employee> getEmployeeById(int id) {
        return employeeDao.getEmployeeById(id);
    }

}
