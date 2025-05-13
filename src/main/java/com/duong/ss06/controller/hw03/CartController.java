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

@WebServlet(name = "CartController", value = "/cart")
public class CartController extends HttpServlet {
    private final ProductService productService = new ProductServiceImpl();
    private final ProductCartService productCartService = new ProductCartServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int userId = 2; // demo cứng userId = 2
        List<ProductCart> cartItems = productCartService.getCartByUserId(userId);
        List<Product> allProducts = productService.getAllProducts();

        req.setAttribute("cartItems", cartItems);
        req.setAttribute("products", allProducts);

        req.getRequestDispatcher("/views/cart.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int cartId = Integer.parseInt(req.getParameter("cartId"));
        boolean success = productCartService.removeFromCart(cartId);

        if (success) {
            resp.sendRedirect(req.getContextPath() + "/cart");
        } else {
            req.setAttribute("errorMessage", "Xóa sản phẩm khỏi giỏ thất bại!");
            doGet(req, resp);
        }
    }
}
