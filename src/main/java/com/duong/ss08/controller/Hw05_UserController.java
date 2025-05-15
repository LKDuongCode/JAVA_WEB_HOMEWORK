package com.duong.ss08.controller;

import com.duong.ss08.model.Hw05_User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
public class Hw05_UserController {

    @GetMapping("/hw05/users")
    public ModelAndView userList() {
        List<Hw05_User> users = new ArrayList<>();

        Hw05_User user1 = new Hw05_User();
        user1.setName("Nguyen Van A");
        user1.setAge(25);
        user1.setBirthday(LocalDate.of(1999, 5, 10));
        user1.setEmail("nva@gmail.com");
        user1.setPhone("0912345678");

        Hw05_User user2 = new Hw05_User();
        user2.setName("Tran Thi B");
        user2.setAge(30);
        user2.setBirthday(LocalDate.of(1994, 2, 20));
        user2.setEmail("ttb@gmail.com");
        user2.setPhone("0987654321");

        Hw05_User user3 = new Hw05_User();
        user3.setName("Le Van C");
        user3.setAge(28);
        user3.setBirthday(LocalDate.of(1996, 7, 15));
        user3.setEmail("lvc@gmail.com");
        user3.setPhone("0909123456");

        users.add(user1);
        users.add(user2);
        users.add(user3);

        ModelAndView modelAndView = new ModelAndView("hw05_userList");
        modelAndView.addObject("users", users);
        return modelAndView;
    }
}