package com.duong.ss11.controller.hw07;

import com.duong.ss11.dto.hw07.ReviewDTO;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ReviewController {
    @GetMapping ("/hw07")
    public String display (@ModelAttribute("reviewDTO")ReviewDTO reviewDTO){
        reviewDTO.setStar(5);
        return "hw07_form";
    }

    @PostMapping("/hw07")
    public String submit (@Valid @ModelAttribute("reviewDTO") ReviewDTO reviewDTO, BindingResult result){
        if(result.hasErrors()) return "hw07_form";
        return "hw07_result";
    }
}
