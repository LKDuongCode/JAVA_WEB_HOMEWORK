package com.duong.ss08.controller;

import com.duong.ss08.model.Hw08_Seeds;
import com.duong.ss08.model.Hw08_User;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class Hw08_GameController {

    private List<Hw08_User> users = new ArrayList<>();
    private List<Hw08_Seeds> seeds = new ArrayList<>();

    public Hw08_GameController() {
        seeds.add(newSeed(1, "Lúa", 500, "https://upload.wikimedia.org/wikipedia/commons/thumb/f/f2/Mature_Rice_%28India%29_by_Augustus_Binu.jpg/500px-Mature_Rice_%28India%29_by_Augustus_Binu.jpg"));
        seeds.add(newSeed(2, "Ngô", 700, "https://upload.wikimedia.org/wikipedia/commons/thumb/2/28/Zea_mays.jpg/500px-Zea_mays.jpg"));
        seeds.add(newSeed(3, "Cà chua", 1000, "https://upload.wikimedia.org/wikipedia/commons/thumb/8/88/Bright_red_tomato_and_cross_section02.jpg/500px-Bright_red_tomato_and_cross_section02.jpg"));
    }

    private Hw08_Seeds newSeed(int id, String name, double price, String url) {
        Hw08_Seeds seed = new Hw08_Seeds();
        seed.setId(id);
        seed.setSeedsName(name);
        seed.setPrice(price);
        seed.setImageUrl(url);
        return seed;
    }

    @GetMapping("/hw08/home")
    public String home(HttpSession session) {
        Hw08_User user = (Hw08_User) session.getAttribute("user");
        if (user == null) {
            return "redirect:/hw08/register";
        }
        return "hw08_home";
    }

    @GetMapping("/hw08/register")
    public String showRegisterForm() {
        return "hw08_register";
    }

    @PostMapping("/hw08/register")
    public String register(@RequestParam("username") String username,
                           @RequestParam("password") String password,
                           @RequestParam("email") String email,
                           HttpSession session, Model model) {
        for (Hw08_User u : users) {
            if (u.getUsername().equals(username)) {
                model.addAttribute("error", "Tên đăng nhập đã tồn tại");
                return "hw08_register";
            }
        }
        Hw08_User user = new Hw08_User();
        user.setId(users.size() + 1);
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);

        users.add(user);
        session.setAttribute("user", user);

        return "redirect:/hw08/home";
    }

    @GetMapping("/hw08/login")
    public String showLoginForm() {
        return "hw08_login";
    }

    @PostMapping("/hw08/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        HttpSession session, Model model) {
        for (Hw08_User u : users) {
            if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
                session.setAttribute("user", u);
                return "redirect:/hw08/home";
            }
        }
        model.addAttribute("error", "Sai tên đăng nhập hoặc mật khẩu");
        return "hw08_login";
    }

    @GetMapping("/hw08/shop")
    public String shop(Model model, HttpSession session) {
        Hw08_User user = (Hw08_User) session.getAttribute("user");
        if (user == null) {
            return "redirect:/hw08/register";
        }
        model.addAttribute("seeds", seeds);
        return "hw08_shop";
    }
}