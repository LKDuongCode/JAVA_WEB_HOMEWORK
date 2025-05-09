package com.duong.ss04;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Hw01_ProductServlet", value = "/hw01")
public class Hw01_ProductServlet extends HttpServlet {
    @Override
    public void init(){
        //init
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Hw01_Product> products = new ArrayList<>();
        initProducts(products);

        req.setAttribute("hw01_products",products);
        req.getRequestDispatcher("hw01_productList.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    public void destroy() {
        super.destroy();
    }

    private void initProducts (List<Hw01_Product> products){
        products.add(new Hw01_Product(1,"laptop",100,"laptop win 11"));
        products.add(new Hw01_Product(2,"iphone",80,"iphone win 10"));
        products.add(new Hw01_Product(3,"tablet",120,"super tablet pro max vip"));
        products.add(new Hw01_Product(4,"airpods",50,"airpods win 11"));
    }
}
