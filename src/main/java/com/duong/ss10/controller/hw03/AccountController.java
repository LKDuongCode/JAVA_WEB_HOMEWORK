package com.duong.ss10.controller.hw03;

import com.duong.ss10.model.Account;
import com.duong.ss10.service.hw03.AccountService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/hw03")
    public String gotoRegister (Model model){
        model.addAttribute("account",new Account());
        return "hw03_register_form";
    }

    @PostMapping("/hw03-register")
    public String saveRegister (@ModelAttribute("account") Account account, Model model){
        Optional<Account> result = accountService.addAccount(account);

        if(result.isEmpty()){
            model.addAttribute("mes","can not to add account!");
            return "error";
        }

        return "hw03_register_form";
    }
}
