package com.duong.ss14.controller.hw06;

import com.duong.ss14.dto.hw06.RegisterUserDTO;
import com.duong.ss14.model.User;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/hw06")
@SessionAttributes("userList")
public class Hw06RegisterController {

    @ModelAttribute("userList")
    public List<User> initUsers() {
        return new ArrayList<>();
    }

    @GetMapping("/register")
    public String showForm(Model model) {
        model.addAttribute("userDTO", new RegisterUserDTO());
        return "hw06_register";
    }

    @PostMapping("/register")
    public String processRegister(
            @Valid @ModelAttribute("userDTO") RegisterUserDTO userDTO,
            BindingResult result,
            Model model,
            @ModelAttribute("userList") List<User> userList
    ) {
        if (!userDTO.getPassword().equals(userDTO.getConfirmPassword())) {
            result.rejectValue("confirmPassword", "hw06.confirmPassword.mismatch");
        }

        if (result.hasErrors()) {
            return "hw06_register";
        }

        userList.add(new User(userDTO.getUsername(), userDTO.getPassword(), userDTO.getEmail()));
        model.addAttribute("message", "hw06.success");
        return "hw06_success";
    }
}