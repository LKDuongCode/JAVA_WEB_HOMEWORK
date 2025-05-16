package com.duong.ss09.controller;

import com.duong.ss09.model.Customer;
import com.duong.ss09.service.hw01.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class LoginController {
    @Autowired
    AuthService authService;

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String processLogin(@RequestParam("username") String username,
                               @RequestParam("password") String password,
                               Model model) {

        if (username == null || username.trim().isEmpty() ||
                password == null || password.trim().isEmpty()) {
            model.addAttribute("error", "Tên đăng nhập và mật khẩu không được để trống.");
            return "login";
        }

        Optional<Customer> optionalCustomer = authService.findByUsername(username);
        if (optionalCustomer.isEmpty()) {
            model.addAttribute("error", "Tài khoản không tồn tại.");
            return "login";
        }

        Customer customer = optionalCustomer.get();

        if (!customer.getPassword().equals(password)) {
            model.addAttribute("error", "Sai mật khẩu.");
            return "login";
        }

        return "redirect:/home";
    }
}
