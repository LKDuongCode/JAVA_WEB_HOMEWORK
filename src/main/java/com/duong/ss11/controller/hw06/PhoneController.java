package com.duong.ss11.controller.hw06;

import com.duong.ss11.dto.hw06.PhoneDTO;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PhoneController {
    @GetMapping("/hw06")
    public String display (@ModelAttribute("phoneDTO")PhoneDTO phoneDTO){
        return "hw06_form";

    }

    @PostMapping("/hw06")
    public String test (@Valid @ModelAttribute("phoneDTO") PhoneDTO phoneDTO, BindingResult result){
        if(result.hasErrors()) return "hw06_form";
        return "hw06_result";
    }
}
