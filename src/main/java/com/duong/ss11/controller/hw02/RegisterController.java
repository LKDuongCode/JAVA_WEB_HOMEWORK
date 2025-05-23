package com.duong.ss11.controller.hw02;

import com.duong.ss11.dto.hw02.RegisterDTO;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {
    @GetMapping("/hw02")
    public String showRegisterForm (@ModelAttribute("registerDTO")RegisterDTO registerDTO){
        return "hw02_register_form";
    }

    @PostMapping("/hw02")
    public String register (@Valid @ModelAttribute("registerDTO") RegisterDTO registerDTO, BindingResult result){
        if(result.hasErrors()){
            return "hw02_register_form";
        }
        return "hw02_result";
    }
}
