package com.duong.ss14.controller.hw02;

import com.duong.ss14.model.ProductItem;
import com.duong.ss14.utils.CookieUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/hw02")
public class ProductCookieController {

    @GetMapping("/add")
    public String showForm(Model model) {
        model.addAttribute("productItem", new ProductItem());
        return "hw02_add";
    }

    @PostMapping("/add")
    public String handleAdd(@ModelAttribute ProductItem productItem,
                            HttpServletRequest request,
                            HttpServletResponse response) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            List<ProductItem> list = CookieUtils.getProductList(request);
            list.add(productItem);

            String encoded = URLEncoder.encode(mapper.writeValueAsString(list), "UTF-8");
            Cookie cookie = new Cookie("productList", encoded);
            cookie.setMaxAge(7 * 24 * 60 * 60);
            response.addCookie(cookie);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "redirect:/hw02/list";
    }


    @GetMapping("/list")
    public String showList(HttpServletRequest request, Model model) {
        List<ProductItem> list = new ArrayList<>();
        try {
            list = CookieUtils.getProductList(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("products", list);
        return "hw02_list";
    }


    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") String id,
                                HttpServletRequest request,
                                HttpServletResponse response) {
        try {
            List<ProductItem> list = CookieUtils.getProductList(request);

            boolean removed = list.removeIf(p -> p.getId() != null && p.getId().equals(id));
            System.out.println("Xoá được không? " + removed);

            ObjectMapper mapper = new ObjectMapper();
            String encoded = URLEncoder.encode(mapper.writeValueAsString(list), StandardCharsets.UTF_8);

            Cookie cookie = new Cookie("productList", encoded);
            cookie.setMaxAge(7 * 24 * 60 * 60);
            response.addCookie(cookie);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "redirect:/hw02/list";
    }

}
