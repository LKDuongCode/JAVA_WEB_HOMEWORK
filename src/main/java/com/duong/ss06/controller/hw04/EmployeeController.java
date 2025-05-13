package com.duong.ss06.controller.hw04;

import com.duong.ss06.model.Employee;
import com.duong.ss06.service.hw04.EmployeeService;
import com.duong.ss06.service.hw04.EmployeeServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

@WebServlet(name = "EmployeeController", value = "/employees")
public class EmployeeController extends HttpServlet {

    private final EmployeeService employeeService = new EmployeeServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) action = "";

        switch (action) {
            case "edit":
                showEditForm(req, resp);
                break;
            case "delete":
                deleteEmployee(req, resp);
                break;
            default:
                listEmployees(req, resp);
        }
    }

    private void listEmployees(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String searchTerm = req.getParameter("search");
        if (searchTerm == null) searchTerm = "";

        List<Employee> employees = employeeService.getAllEmployees(searchTerm);
        req.setAttribute("employees", employees);
        req.getRequestDispatcher("/views/hw04/employeeList.jsp").forward(req, resp);
    }

    private void showEditForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Optional<Employee> employeeOpt = employeeService.getEmployeeById(id);

        if (employeeOpt.isPresent()) {
            req.setAttribute("employee", employeeOpt.get());
            req.getRequestDispatcher("/views/hw04/updateEmployee.jsp").forward(req, resp);
        } else {
            resp.sendRedirect(req.getContextPath() + "/employees?error=NotFound");
        }
    }

    private void deleteEmployee(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        boolean success = employeeService.deleteEmployee(id);

        resp.sendRedirect(req.getContextPath() + "/employees?deleted=" + success);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) action = "";

        switch (action) {
            case "add":
                addEmployee(req, resp);
                break;
            case "update":
                updateEmployee(req, resp);
                break;
            default:
                resp.sendRedirect(req.getContextPath() + "/employees");
        }
    }

    private void addEmployee(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Employee employee = extractEmployeeFromRequest(req, false);
        boolean success = employeeService.addEmployee(employee);

        resp.sendRedirect(req.getContextPath() + "/employees?added=" + success);
    }

    private void updateEmployee(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Employee employee = extractEmployeeFromRequest(req, true);
        boolean success = employeeService.updateEmployee(employee);

        resp.sendRedirect(req.getContextPath() + "/employees?updated=" + success);
    }

    private Employee extractEmployeeFromRequest(HttpServletRequest req, boolean isUpdate) {
        int id = isUpdate ? Integer.parseInt(req.getParameter("id")) : 0;
        String name = req.getParameter("name");
        Date birthday = Date.valueOf(req.getParameter("birthday"));
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");
        BigDecimal salary = new BigDecimal(req.getParameter("salary"));
        String position = req.getParameter("position");

        if (isUpdate) {
            return new Employee(id, name, birthday, phone, email, salary, position);
        } else {
            return new Employee(name, birthday, phone, email, salary, position);
        }
    }
}
