package com.duong.ss20.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping
    public String goIndex (Model model){
        model.addAttribute("welcome","WELCOME TO MY HOMEWORKS SS20!");
        return "index";
    }
}
