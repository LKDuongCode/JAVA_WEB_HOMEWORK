package com.duong.ss02.hw04;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "RegisterServlet", value = "/register")
public class RegisterServlet extends HttpServlet {
    String trueName;
    String trueEmail;
    @Override
    public void init() {
       trueName = "duong";
       trueEmail = "duong@gmail.com";
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException , ServletException{
        RequestDispatcher dispatcher = request.getRequestDispatcher("pages/register.jsp");
        dispatcher.forward(request,response);
    }

    @Override
    protected void doPost (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");

        if(trueName.equals(username) && trueEmail.equals(email)){
            response.sendRedirect("pages/thankyou.jsp?username="
                    + URLEncoder.encode(username, StandardCharsets.UTF_8)
                    + "&email="
                    + URLEncoder.encode(email, StandardCharsets.UTF_8));
            // cách này có thể truyền qua redirect và sử dụng bằng param.
        }else {
            request.setAttribute("error", "thông tin nhập vào không đúng!");
            RequestDispatcher dispatcher = request.getRequestDispatcher("pages/register.jsp");
            dispatcher.forward(request, response);
        }

    }

    public void destroy() {
    }
}
