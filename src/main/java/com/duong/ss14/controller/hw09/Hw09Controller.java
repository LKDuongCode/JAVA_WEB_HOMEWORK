package com.duong.ss14.controller.hw09;

import com.duong.ss14.model.Transaction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;



@Controller
@RequestMapping("/hw09")
@SessionAttributes("transactions")
public class Hw09Controller {

    @ModelAttribute("transactions")
    public List<Transaction> initTransactions() {
        return new ArrayList<>();
    }


    @GetMapping("/add")
    public String showAddForm() {
        return "hw09_add";
    }

    @PostMapping("/add")
    public String handleAddTransaction(
            @RequestParam("description") String description,
            @RequestParam("amount") double amount,
            @RequestParam("type") String type,
            @ModelAttribute("transactions") List<Transaction> transactions
    ) {
        transactions.add(new Transaction(description, amount, type));
        return "redirect:/hw09/list";
    }


    @GetMapping("/list")
    public String showList(Model model,
                           @ModelAttribute("transactions") List<Transaction> transactions) {
        model.addAttribute("transactions", transactions);
        return "hw09_list";
    }


    @GetMapping("/delete/{index}")
    public String deleteTransaction(@PathVariable("index") int index,
                                    @ModelAttribute("transactions") List<Transaction> transactions) {
        if (index >= 0 && index < transactions.size()) {
            transactions.remove(index);
        }
        return "redirect:/hw09/list";
    }
}

