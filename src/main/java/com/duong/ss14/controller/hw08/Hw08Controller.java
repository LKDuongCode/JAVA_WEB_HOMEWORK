package com.duong.ss14.controller.hw08;

import com.duong.ss14.model.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/hw08")
@SessionAttributes("order")
public class Hw08Controller {

    @ModelAttribute("order")
    public Order initOrder() {
        return new Order();
    }

    @GetMapping("/order")
    public String showOrderForm(Model model) {
        model.addAttribute("order", new Order());
        return "hw08_order";
    }

    @PostMapping("/order")
    public String handleOrder(
            @RequestParam(name = "customerName") String customerName,
            @RequestParam(name = "product") String product,
            @RequestParam(name = "quantity") int quantity,
            @ModelAttribute("order") Order order,
            Model model
    ) {
        order.setCustomerName(customerName);
        order.setProduct(product);
        order.setQuantity(quantity);
        model.addAttribute("message", "Đặt hàng thành công!");
        return "hw08_order_success";
    }

    @GetMapping("/view")
    public String viewOrder(@ModelAttribute("order") Order order, Model model) {
        model.addAttribute("order", order);
        return "hw08_order_view";
    }
}