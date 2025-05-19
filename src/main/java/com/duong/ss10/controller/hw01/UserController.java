package com.duong.ss10.controller.hw01;

import com.duong.ss10.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @GetMapping("/hw01")
    public String goToHw01 (Model model){
        User u = new User();
        model.addAttribute("user",u);
        return "hw01_user";
    }

    @PostMapping("/hw01")
    public String submitForm(@ModelAttribute("user") User u,  Model model){
        model.addAttribute("user",u);
        return "hw01_result";
    }
}
