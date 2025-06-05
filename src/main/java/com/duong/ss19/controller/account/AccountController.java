package com.duong.ss19.controller.account;

import com.duong.ss19.dto.account.UpdateStatusAccountDTO;
import com.duong.ss19.entity.account.Account;
import com.duong.ss19.entity.account.AccountStatus;
import com.duong.ss19.service.account.AccountService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin/accounts")
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/{page}")
    public String goAccounts(@PathVariable("page") int page, Model model) {
        int pageSize = 5;

        List<Account> accounts = accountService.findAllWithPagination(page,pageSize);
        int totalAccounts = accountService.countAccount();
        int totalPages = (int) Math.ceil((double) totalAccounts/pageSize);

        model.addAttribute("accounts", accounts);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("curPage", page);
        return "account_list";
    }

    @PostMapping("/change-status/{id}")
    public String changeAccountStatus (@PathVariable("id") int id){
        Optional<Account> accountOptional = accountService.findById(id);
        if(accountOptional.isEmpty()) return "account_list";
        Account acc = accountOptional.get();
        UpdateStatusAccountDTO updateStatusAccountDTO = new UpdateStatusAccountDTO();
        updateStatusAccountDTO.setId(acc.getId());
        updateStatusAccountDTO.setStatus(
                acc.getStatus() == AccountStatus.ACTIVE
                        ? AccountStatus.INACTIVE
                        : AccountStatus.ACTIVE
        );


        if(!accountService.update(updateStatusAccountDTO)) return "account_list";

        return "redirect:/admin/accounts/1";
    }

}
