package com.duong.ss08.controller;

import com.duong.ss08.model.Hw04_User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class Hw04_RegistrationController {

    @GetMapping("/hw04/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new Hw04_User());
        return "hw04_registration";
    }


    @PostMapping("/hw04/register")
    public String submitRegistration(@ModelAttribute Hw04_User user, Model model) {
        boolean hasError = false;

        if (user.getName() == null || user.getName().trim().isEmpty()) {
            model.addAttribute("nameError", "Tên không được để trống");
            hasError = true;
        }

        if (user.getEmail() == null || !user.getEmail().matches("^[a-zA-Z0-9]+@gmail\\.com$")) {
            model.addAttribute("emailError", "Email phải có dạng abc123@gmail.com");
            hasError = true;
        }

        if (user.getPhone() == null || !user.getPhone().matches("^\\d{10,11}$")) {
            model.addAttribute("phoneError", "Số điện thoại phải gồm 10-11 chữ số");
            hasError = true;
        }

        if (hasError) {
            return "hw04_registration";
        }

        model.addAttribute("user", user);
        return "hw04_result";
    }
}
