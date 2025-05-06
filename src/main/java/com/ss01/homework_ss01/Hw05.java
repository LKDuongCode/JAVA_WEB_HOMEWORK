package com.ss01.homework_ss01;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "hw05", value = "/hw05")
public class Hw05 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int a = 10;
            int b = 0;
            int result = a / b;

            req.setAttribute("result", result);
            req.getRequestDispatcher("pages/hw05.jsp").forward(req, resp);

        } catch (Exception e) {
            req.setAttribute("errorMessage", "Có lỗi xảy ra: " + e.getMessage());
            req.getRequestDispatcher("pages/error.jsp").forward(req, resp);
        }
    }
}
