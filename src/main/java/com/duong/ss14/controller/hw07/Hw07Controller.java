package com.duong.ss14.controller.hw07;

import com.duong.ss14.model.LoginForm;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/hw07")
@SessionAttributes("user")
public class Hw07Controller {

    @ModelAttribute("user")
    public String initUser() {
        return null;
    }

    @GetMapping("/login")
    public String showLoginForm(Model model, HttpServletRequest request) {
        LoginForm form = new LoginForm();

        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                if ("username".equals(c.getName())) {
                    form.setUsername(c.getValue());
                    form.setRememberMe(true);
                }
            }
        }

        model.addAttribute("loginForm", form);
        return "hw07_login";
    }

    @PostMapping("/login")
    public String handleLogin(
            @ModelAttribute("loginForm") LoginForm loginForm,
            Model model,
            HttpServletResponse response
    ) {
        if ("admin".equals(loginForm.getUsername()) && "123".equals(loginForm.getPassword())) {
            model.addAttribute("user", loginForm.getUsername());


            if (loginForm.isRememberMe()) {
                Cookie cookie = new Cookie("username", loginForm.getUsername());
                cookie.setMaxAge(7 * 24 * 60 * 60); // 7 ngày
                response.addCookie(cookie);
            } else {

                Cookie cookie = new Cookie("username", "");
                cookie.setMaxAge(0);
                response.addCookie(cookie);
            }

            return "redirect:/hw07/welcome";
        }

        model.addAttribute("error", "Thông tin đăng nhập không đúng!");
        return "hw07_login";
    }

    @GetMapping("/welcome")
    public String welcomePage(@ModelAttribute("user") String username, Model model) {
        model.addAttribute("username", username);
        return "hw07_welcome";
    }
}