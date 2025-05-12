package com.duong.ss05.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "Hw02_Controller", value = "/hw02")
public class Hw02_Controller extends HttpServlet {
    @Override
    public void init(){
        //init
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect(req.getContextPath() + "/views/hw02_student.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String name = req.getParameter("name");
            String address  = req.getParameter("address");
            int age  = Integer.parseInt(req.getParameter("age"));



            req.setAttribute("name",name);
            req.setAttribute("age",age);
            req.setAttribute("address",address);

            req.getRequestDispatcher("/views/hw02_confirm.jsp").forward(req,resp);
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
