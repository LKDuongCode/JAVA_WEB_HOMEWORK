package com.duong.ss04;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Hw05_SearchServlet", value = "/hw05")
public class Hw05_SearchServlet extends HttpServlet {

    private List<Hw05_Product> products;

    @Override
    public void init() {
        products = new ArrayList<>();
        products.add(new Hw05_Product("1", "iPhone 15", 999.99, "Latest iPhone model"));
        products.add(new Hw05_Product("2", "Samsung S24", 899.99, "Newest Samsung flagship"));
        products.add(new Hw05_Product("3", "Xiaomi 13", 699.99, "Affordable flagship killer"));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("product", null);
        req.getRequestDispatcher("hw05_search.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String searchId = req.getParameter("productId");
        Hw05_Product foundProduct = null;
        for (Hw05_Product p : products) {
            if (p.getId().equals(searchId)) {
                foundProduct = p;
                break;
            }
        }
        req.setAttribute("product", foundProduct);
        req.getRequestDispatcher("hw05_search.jsp").forward(req, resp);
    }
}
