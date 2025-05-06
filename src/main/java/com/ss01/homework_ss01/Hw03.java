package com.ss01.homework_ss01;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "hw03", value = "/hw03")
public class Hw03 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = "Lê Khánh Dương";
        int age = 20;
        String schoolName = "Rikkei Academy";

        request.setAttribute("name", name);
        request.setAttribute("age", age);
        request.setAttribute("school",schoolName);

        request.getRequestDispatcher("pages/hw03.jsp").forward(request, response);
    }
}
