package com.duong.ss04;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "Hw04_CheckNullServlet", value = "/hw04")
public class Hw04_CheckNullServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String product = "iPhone 15 Pro Max";

        req.setAttribute("product", product);
        req.getRequestDispatcher("hw04_check_null.jsp").forward(req, resp);
    }
}
