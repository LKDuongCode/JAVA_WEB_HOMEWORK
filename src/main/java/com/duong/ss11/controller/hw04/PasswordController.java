package com.duong.ss11.controller.hw04;

import com.duong.ss11.dto.hw04.PasswordDTO;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PasswordController {
    @GetMapping ("/hw04")
    public String display (@ModelAttribute("password")PasswordDTO passwordDTO){
        return "hw04_password_form";
    }

    @PostMapping ("/hw04")
    public String test (@Valid @ModelAttribute ("password") PasswordDTO passwordDTO, BindingResult bindingResult){
        if(bindingResult.hasErrors()) return "hw04_password_form";
        return "hw04_result";
    }
}
