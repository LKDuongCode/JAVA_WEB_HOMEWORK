package com.duong.ss14.controller.hw05;

import com.duong.ss14.model.OrderItem;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/hw05")
@SessionAttributes("orders")
public class Hw05OrderController {

    @ModelAttribute("orders")
    public List<OrderItem> initOrders() {
        return new ArrayList<>();
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("orderItem", new OrderItem());
        return "hw05_add";
    }

    @PostMapping("/add")
    public String handleAdd(@ModelAttribute("orderItem") OrderItem item,
                            @ModelAttribute("orders") List<OrderItem> orders) {
        orders.add(item);
        return "redirect:/hw05/list";
    }

    @GetMapping("/list")
    public String showList(Model model,
                           @ModelAttribute("orders") List<OrderItem> orders) {
        model.addAttribute("orders", orders);
        return "hw05_list";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable("id") String id,
                           @ModelAttribute("orders") List<OrderItem> orders,
                           Model model) {
        for (OrderItem item : orders) {
            if (item.getOrderId().equals(id)) {
                model.addAttribute("orderItem", item);
                model.addAttribute("originalId", id);
                return "hw05_edit";
            }
        }
        return "redirect:/hw05/list";
    }

    @PostMapping("/edit")
    public String handleEdit(@RequestParam("originalId") String originalId,
                             @ModelAttribute("orderItem") OrderItem updatedItem,
                             @ModelAttribute("orders") List<OrderItem> orders) {
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getOrderId().equals(originalId)) {
                orders.set(i, updatedItem);
                break;
            }
        }
        return "redirect:/hw05/list";
    }

    @GetMapping("/delete/{id}")
    public String handleDelete(@PathVariable("id") String id,
                               @ModelAttribute("orders") List<OrderItem> orders) {
        orders.removeIf(item -> item.getOrderId().equals(id));
        return "redirect:/hw05/list";
    }
}