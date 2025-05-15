package com.duong.ss08.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Hw01_WelcomeController {
    @GetMapping("/hw01")
    public String goToWelcome (){
        return "hw01_welcome";
    }
}
