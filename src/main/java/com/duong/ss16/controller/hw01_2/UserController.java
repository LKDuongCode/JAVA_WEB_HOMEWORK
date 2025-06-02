package com.duong.ss16.controller.hw01_2;

import com.duong.ss16.dto.hw01.LoginUserDTO;
import com.duong.ss16.dto.hw01.RegisterUserDTO;
import com.duong.ss16.model.hw01.User;
import com.duong.ss16.model.hw01.UserRole;
import com.duong.ss16.service.hw01.UserService;
import com.duong.ss16.service.hw04.BusTripService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/hw01")
public class UserController {
    private final UserService userService;
    private final BusTripService busTripService;

    public UserController(UserService userService, BusTripService busTripService) {
        this.userService = userService;
        this.busTripService = busTripService;
    }

    @GetMapping("/register")
    public String goRegister (@ModelAttribute("registerDTO")RegisterUserDTO registerUserDTO){
        return "hw01_register";
    }

    @GetMapping("/login")
    public String goLogin ( @ModelAttribute("loginDTO") LoginUserDTO loginUserDTO){
        return "hw01_login";
    }

    @PostMapping("/register")
    public String handleRegister (@Valid @ModelAttribute("registerDTO") RegisterUserDTO registerUserDTO, BindingResult result, Model model){
        if (result.hasErrors()) {
            return "hw01_register";
        }

        if(!userService.registerUser(registerUserDTO)){
            model.addAttribute("message","register failed!");
            return "hw01_register";
        }

        return "redirect:/hw01/login";
    }

    @PostMapping("/login")
    public String handleLogin (@Valid @ModelAttribute("loginDTO") LoginUserDTO loginUserDTO, BindingResult result, Model model){
        if(result.hasErrors()) return "hw01_login";

        Optional<User> opt = userService.loginUser(loginUserDTO);
        if(opt.isEmpty()){
            model.addAttribute("message","email or password is wrong!");
            return "hw01_login";
        }

        User u = opt.get();

        if(u.getRole() == UserRole.ADMIN){
            return "hw01_dashboard";
        }

        model.addAttribute("busTrips", busTripService.getAll());
        return "hw01_hw02_user_home";
    }
}
