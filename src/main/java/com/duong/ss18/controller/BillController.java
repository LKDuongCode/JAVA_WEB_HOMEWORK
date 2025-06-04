package com.duong.ss18.controller;

import com.duong.ss18.entity.Bill;
import com.duong.ss18.entity.enums.BillStatus;
import com.duong.ss18.service.bill.BillService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/admin/bills")
public class BillController {

    private final BillService billService;

    public BillController(BillService billService) {
        this.billService = billService;
    }

    @GetMapping
    public String listBills(@RequestParam(name = "username", required = false) String username,
                            @RequestParam(name = "status", required = false) String status,
                            @RequestParam(name = "from", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate from,
                            @RequestParam(name = "to", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate to,
                            @RequestParam(name = "page", defaultValue = "1") int page,
                            @RequestParam(name = "size", defaultValue = "5") int size,
                            Model model) {
        List<Bill> bills = billService.filterBills(username, status, from, to, page, size);
        model.addAttribute("bills", bills);
        model.addAttribute("currentPage", page);
        model.addAttribute("username", username);
        model.addAttribute("status", status);
        model.addAttribute("from", from);
        model.addAttribute("to", to);
        return "admin_bills_management";
    }

    @GetMapping("/update/{id}/{newStatus}")
    public String updateStatus(@PathVariable("id") int id, @PathVariable("newStatus") String newStatus,
                               RedirectAttributes redirectAttributes) {
        try {
            BillStatus status = BillStatus.valueOf(newStatus.toUpperCase());
            billService.updateStatus(id, status);
            redirectAttributes.addFlashAttribute("message", "Cập nhật trạng thái thành công");
        } catch (IllegalArgumentException e) {
            redirectAttributes.addFlashAttribute("error", "Trạng thái không hợp lệ");
        }
        return "redirect:/admin/bills";
    }
}
