package com.duong.ss06.controller.hw03;

import com.duong.ss06.model.Product;
import com.duong.ss06.model.ProductCart;
import com.duong.ss06.service.hw03.ProductCartService;
import com.duong.ss06.service.hw03.ProductCartServiceImpl;
import com.duong.ss06.service.hw03.ProductService;
import com.duong.ss06.service.hw03.ProductServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductController", value = "/products")
public class ProductController extends HttpServlet {
    private final ProductService productService = new ProductServiceImpl();
    private final ProductCartService productCartService = new ProductCartServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> products = productService.getAllProducts();
        req.setAttribute("products", products);

        req.getRequestDispatcher("/views/listProduct.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int userId = 2; // demo cứng userId = 2, sau này lấy từ session
        int productId = Integer.parseInt(req.getParameter("productId"));
        int quantity = Integer.parseInt(req.getParameter("quantity"));

        ProductCart cartItem = new ProductCart(userId, productId, quantity);
        boolean success = productCartService.addToCart(cartItem);

        if (success) {
            resp.sendRedirect(req.getContextPath() + "/cart");
        } else {
            req.setAttribute("errorMessage", "Thêm vào giỏ thất bại!");
            doGet(req, resp);
        }
    }
}
