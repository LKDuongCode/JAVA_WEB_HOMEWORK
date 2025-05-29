package com.duong.ss14.controller.hw01;

import com.duong.ss14.dto.hw01.LoginUserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/hw01")
@SessionAttributes("loggedInUser")
public class LoginController {
    
    private static final String VALID_USERNAME = "admin";
    private static final String VALID_PASSWORD = "123";

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("loginUserDTO", new LoginUserDTO());
        return "hw01_login";
    }

    @PostMapping("/login")
    public String handleLogin(@ModelAttribute("loginUserDTO") LoginUserDTO dto,
                              Model model) {
        if (VALID_USERNAME.equals(dto.getName()) && VALID_PASSWORD.equals(dto.getPassword())) {
            model.addAttribute("loggedInUser", dto);
            return "redirect:/hw01/welcome";
        } else {
            model.addAttribute("error", "Sai tên đăng nhập hoặc mật khẩu!");
            return "hw01_login";
        }
    }

    @GetMapping("/welcome")
    public String showWelcomePage(@ModelAttribute("loggedInUser") LoginUserDTO user, Model model) {
        model.addAttribute("name", user.getName());
        return "hw01_welcome";
    }
}
