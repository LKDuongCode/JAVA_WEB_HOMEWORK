package com.duong.ss18.controller;

import com.duong.ss18.entity.Account;
import com.duong.ss18.entity.enums.AccountStatus;
import com.duong.ss18.service.account.AccountService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/admin/accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public String listAccounts(@RequestParam(name = "page", defaultValue = "1") int page,
                               @RequestParam(name = "size", defaultValue = "5") int size,
                               @RequestParam(name = "keyword", required = false) String keyword,
                               Model model) {

        List<Account> accounts;
        if (keyword != null && !keyword.trim().isEmpty()) {
            accounts = accountService.searchAccountsByUsername(keyword, page, size);
            model.addAttribute("keyword", keyword);
        } else {
            accounts = accountService.getAllAccounts(page, size);
        }

        model.addAttribute("accounts", accounts);
        model.addAttribute("currentPage", page);
        return "admin_accounts_management";
    }


    @GetMapping("/lock/{id}")
    public String lockAccount(@PathVariable ("id") int id, RedirectAttributes redirectAttributes) {
        accountService.updateAccountStatus(id, AccountStatus.INACTIVE);
        redirectAttributes.addFlashAttribute("message", "Đã khóa tài khoản.");
        return "redirect:/admin/accounts";
    }


    @GetMapping("/unlock/{id}")
    public String unlockAccount(@PathVariable ("id") int id, RedirectAttributes redirectAttributes) {
        accountService.updateAccountStatus(id, AccountStatus.ACTIVE);
        redirectAttributes.addFlashAttribute("message", "Đã mở khóa tài khoản.");
        return "redirect:/admin/accounts";
    }
}
