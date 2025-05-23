package com.duong.ss11.controller.hw03;

import com.duong.ss11.dto.hw03.Hw03DTO;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomEmailController {
    @GetMapping ("/hw03")
    public String displayHw03Form (@ModelAttribute("hw03DTO")Hw03DTO hw03DTO){
        return "hw03_custom_validator";
    }

    @PostMapping("/hw03")
    public String test (@Valid @ModelAttribute("hw03DTO") Hw03DTO hw03DTO, BindingResult result){
        if(result.hasErrors()){
            return "hw03_custom_validator";
        }
        return "hw03_result";
    }
}
