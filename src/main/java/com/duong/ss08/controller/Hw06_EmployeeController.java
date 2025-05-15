package com.duong.ss08.controller;

import com.duong.ss08.model.Hw06_Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class Hw06_EmployeeController {

    private List<Hw06_Employee> employees = new ArrayList<>();

    @GetMapping("/hw06/employees")
    public String showEmployeeList(Model model) {
        model.addAttribute("employees", employees);
        return "hw06_listEmployee";
    }

    @GetMapping("/hw06/employees/add")
    public String showAddEmployeeForm(Model model) {
        model.addAttribute("employee", new Hw06_Employee());
        return "hw06_addEmployee";
    }

    @PostMapping("/hw06/employees")
    public String addEmployee(@ModelAttribute Hw06_Employee employee, Model model) {
        employees.add(employee);
        model.addAttribute("message", "Thêm nhân viên thành công!");
        model.addAttribute("employees", employees);
        return "hw06_listEmployee";
    }
}