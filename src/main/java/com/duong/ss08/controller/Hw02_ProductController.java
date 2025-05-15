package com.duong.ss08.controller;

import com.duong.ss08.service.hw02.Hw02_ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class Hw02_ProductController {
    @Autowired
    Hw02_ProductService hw02ProductService;

    @GetMapping("/hw02")
    public String productList(Model model) {
        List<String> products = hw02ProductService.getAllProduct();
        model.addAttribute("products", products);
        return "hw02_product_list";
    }


    @GetMapping("/hw02/add")
    public String showAddForm() {
        return "hw02_addProduct";
    }


    @PostMapping("/hw02/add")
    public String addProduct(@RequestParam("name") String name) {
        hw02ProductService.addProduct(name);
        return "redirect:/hw02";
    }

}
