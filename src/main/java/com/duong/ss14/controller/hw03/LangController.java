package com.duong.ss14.controller.hw03;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hw03")
public class LangController {

    @GetMapping
    public String showHomePage() {
        return "hw03_home";
    }

    @PostMapping("/change-lang")
    public String changeLanguage(@RequestParam("lang") String lang, HttpServletResponse response) {
        Cookie cookie = new Cookie("lang", lang);
        cookie.setMaxAge(30 * 24 * 60 * 60); // 30 ngày
        response.addCookie(cookie);
        return "redirect:/hw03?lang=" + lang;
    }
}
