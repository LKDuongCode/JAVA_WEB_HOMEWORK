package com.duong.ss18.controller;

import com.duong.ss18.entity.Account;
import com.duong.ss18.entity.Bill;
import com.duong.ss18.entity.Product;
import com.duong.ss18.service.account.AccountService;
import com.duong.ss18.service.bill.BillService;
import com.duong.ss18.service.product.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class DashboardController {

    private final AccountService accountService;
    private final ProductService productService;
    private final BillService billService;

    public DashboardController(AccountService accountService,
                               ProductService productService,
                               BillService billService) {
        this.accountService = accountService;
        this.productService = productService;
        this.billService = billService;
    }

    @GetMapping("/dashboard")
    public String showDashboard(Model model) {
        List<Account> users = accountService.getAllAccounts(1, 5);

        List<Product> products = productService.getAllProductsWithPagination(1, 5);


        List<Bill> bills = billService.filterBills(null, null, null, null, 1, 5);


        List<Bill> allBills = billService.filterBills(null, "COMPLETED", null, null, 1, 1000);
        double totalRevenue = allBills.stream()
                .mapToDouble(Bill::getTotalMoney)
                .sum();

        model.addAttribute("users", users);
        model.addAttribute("products", products);
        model.addAttribute("bills", bills);
        model.addAttribute("totalRevenue", totalRevenue);

        return "admin_dashboard";
    }
}
