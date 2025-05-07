package com.duong.ss02.hw02;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "UserinfoServlet", value = "/user-info")
public class UserinfoServlet extends HttpServlet {
    @Override
    public void init() {
       // init
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("username");
        String age = req.getParameter("age");

        req.setAttribute("name",name);
        req.setAttribute("age",age);
        req.getRequestDispatcher("pages/hw02.jsp").forward(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("pages/hw02.jsp").forward(req, resp);
    }


    public void destroy() {
    }
}
