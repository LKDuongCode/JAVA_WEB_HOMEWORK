package com.duong.ss02.hw06;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ProductServlet", value = "/product-servlet")
public class ProductServlet extends HttpServlet {
    public static List<Product> products = new ArrayList<>();
    public static int countId = 1;
    @Override
    public void init(){
        //init
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        if ("showEdit".equals(action)) {
            int id = Integer.parseInt(req.getParameter("productId"));
            for (Product p : products) {
                if (p.getId() == id) {
                    req.setAttribute("product", p);
                    break;
                }
            }
            req.getRequestDispatcher("pages/productEdit.jsp").forward(req, resp);
        } else {
            req.setAttribute("products", products);
            req.getRequestDispatcher("pages/productList.jsp").forward(req, resp);
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        String productId = req.getParameter("productId");
        if("add".equals(action)){
            String name = req.getParameter("name");
            String price = req.getParameter("price");
            double realPrice = Double.parseDouble(price);
            products.add(new Product(countId++,name,realPrice));
            req.setAttribute("products", products);
            req.getRequestDispatcher("pages/productList.jsp").forward(req,resp);
        }
        else if ("edit".equals(action)) {
            int id = Integer.parseInt(req.getParameter("productId"));
            String name = req.getParameter("name");
            double price = Double.parseDouble(req.getParameter("price"));

            for (Product p : products) {
                if (p.getId() == id) {
                    p.setName(name);
                    p.setPrice(price);
                    break;
                }
            }

            resp.sendRedirect("product-servlet");
        }

        else if ("delete".equals(action)) {
            int id = Integer.parseInt(req.getParameter("productId"));
            products.removeIf(p -> p.getId() == id);
        }

        resp.sendRedirect("product-servlet");
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
