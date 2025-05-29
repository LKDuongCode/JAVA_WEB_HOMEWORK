package com.duong.ss14.controller.hw04;

import com.duong.ss14.model.Product;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/hw04")
@SessionAttributes("cart")
public class CartController {

    @ModelAttribute("cart")
    public List<Product> initCart() {
        return new ArrayList<>();
    }

    @GetMapping("/add")
    public String showForm(Model model) {
        model.addAttribute("product", new Product());
        return "hw04_add";
    }

    @PostMapping("/add")
    public String handleAdd(@ModelAttribute Product product,
                            @ModelAttribute("cart") List<Product> cart,
                            HttpServletResponse response) {
        cart.add(product);

        String encoded = URLEncoder.encode(product.getName(), StandardCharsets.UTF_8);
        Cookie cookie = new Cookie("lastProduct", encoded);
        cookie.setMaxAge(7 * 24 * 60 * 60); // 7 ngày
        response.addCookie(cookie);

        return "redirect:/hw04/list";
    }

    @GetMapping("/list")
    public String showCart(@ModelAttribute("cart") List<Product> cart,
                           Model model,
                           @CookieValue(value = "lastProduct", defaultValue = "") String lastProduct) {
        model.addAttribute("cart", cart);
        model.addAttribute("lastProduct", lastProduct);
        return "hw04_list";
    }

    @GetMapping("/delete/{name}")
    public String deleteProduct(@PathVariable("name") String name,
                                @ModelAttribute("cart") List<Product> cart) {
        cart.removeIf(p -> p.getName().equalsIgnoreCase(name));
        return "redirect:/hw04/list";
    }
}
