package com.duong.ss11.controller.hw01;

import com.duong.ss11.dto.hw01.InfoDTO;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class InfoController {

    @GetMapping("/hw01")
    public String showInfoForm (@ModelAttribute("infoDTO")InfoDTO infoDTO){
        return "hw01_info_form";
    }

    @PostMapping("/hw01")
    public String getInfo (@Valid @ModelAttribute("infoDTO") InfoDTO infoDTO, BindingResult result){
        if(result.hasErrors()){
            return "hw01_info_form";
        }
        return "hw01_result";
    }
}
