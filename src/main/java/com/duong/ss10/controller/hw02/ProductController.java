package com.duong.ss10.controller.hw02;

import com.duong.ss10.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ProductController {
    @GetMapping("/hw02")
    public String gotoAddForm (Model model){
        if (!model.containsAttribute("product")) {
            model.addAttribute("product", new Product());
        }
        return "hw02_product_form";
    }

    @PostMapping("/hw02-result")
    public String addProduct (@ModelAttribute("product") Product p, RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("product",p);
        return "redirect:/hw02";
    }
}
