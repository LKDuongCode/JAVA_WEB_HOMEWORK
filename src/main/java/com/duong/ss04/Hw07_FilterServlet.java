package com.duong.ss04;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name = "Hw07_FilterServlet", value = "/hw07")
public class Hw07_FilterServlet extends HttpServlet {

    private List<Hw07_Product> products;

    @Override
    public void init() {
        products = new ArrayList<>();
        products.add(new Hw07_Product("P01", "Laptop", 1200));
        products.add(new Hw07_Product("P02", "Smartphone", 800));
        products.add(new Hw07_Product("P03", "Tablet", 450));
        products.add(new Hw07_Product("P04", "Earbuds", 99));
        products.add(new Hw07_Product("P05", "Monitor", 300));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("filteredProducts", null);
        req.getRequestDispatcher("hw07_filter.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        double minPrice = 0;
        double maxPrice = Double.MAX_VALUE;

        try {
            String minStr = req.getParameter("minPrice");
            String maxStr = req.getParameter("maxPrice");

            if (minStr != null && !minStr.isEmpty()) {
                minPrice = Double.parseDouble(minStr);
            }
            if (maxStr != null && !maxStr.isEmpty()) {
                maxPrice = Double.parseDouble(maxStr);
            }

        } catch (NumberFormatException e) {
            System.err.println("Lỗi chuyển đổi số: " + e.getMessage());
        }

        List<Hw07_Product> filtered = new ArrayList<>();
        for (Hw07_Product p : products) {
            if (p.getPrice() >= minPrice && p.getPrice() <= maxPrice) {
                filtered.add(p);
            }
        }
        req.setAttribute("filteredProducts", filtered);
        req.getRequestDispatcher("hw07_filter.jsp").forward(req, resp);
    }
}
