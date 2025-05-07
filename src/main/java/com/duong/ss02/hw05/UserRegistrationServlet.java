package com.duong.ss02.hw05;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet(name = "UserRegistrationServlet", value = "/user-registration-servlet")
public class UserRegistrationServlet extends HttpServlet {
    @Override
    public void init(){
        //init
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("pages/hw05.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       try {
           UserInfoHw05 userInfo = new UserInfoHw05();
           userInfo.setName(req.getParameter("name"));
           userInfo.setEmail(replaceEmail(req.getParameter("email")));
           userInfo.setPassword(replacePassword(req.getParameter("password")));

           req.setAttribute("user",userInfo);

           req.getRequestDispatcher("pages/userInfo.jsp").forward(req,resp);
       }catch (Exception e){
           resp.sendRedirect("pages/hw05.jsp?error=1");
       }
    }

    @Override
    public void destroy() {
        super.destroy();
    }

    public static String replaceEmail(String email) {
        if (email == null || !email.contains("@gmail.com")) {
            return email;
        }

        int visibleChars = 2;
        int atIndex = email.indexOf("@");
        String prefix = email.substring(0, visibleChars);
        String stars = "*".repeat(Math.max(0, atIndex - visibleChars));
        return prefix + stars + "@gmail.com";
    }

    public static String replacePassword(String pass) {
        if (pass == null) {
            return pass;
        }
        return "*".repeat(pass.length());
    }

}
