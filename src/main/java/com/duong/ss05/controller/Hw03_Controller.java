package com.duong.ss05.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "Hw03_Controller", value = "/hw03")
public class Hw03_Controller extends HttpServlet {
    @Override
    public void init(){
        //init
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Hiển thị form nhập liệu khi GET
        req.getRequestDispatcher("/views/hw03_user_info.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String ageStr = req.getParameter("age");
        String address = req.getParameter("address");

        if (name == null || name.isEmpty() || ageStr == null || ageStr.isEmpty() || address == null || address.isEmpty()) {
            req.setAttribute("errorMsg", "Vui lòng nhập đầy đủ thông tin.");
            req.getRequestDispatcher("/views/hw03_user_info.jsp").forward(req, resp);
            return;
        }

        int age;
        try {
            age = Integer.parseInt(ageStr);
            if (age <= 0) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            req.setAttribute("errorMsg", "Tuổi phải là số nguyên dương hợp lệ.");
            req.getRequestDispatcher("/views/hw03_user_info.jsp").forward(req, resp);
            return;
        }

        req.setAttribute("name", name);
        req.setAttribute("age", age);
        req.setAttribute("address", address);

        req.getRequestDispatcher("/views/hw03_confirm.jsp").forward(req, resp);
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}

