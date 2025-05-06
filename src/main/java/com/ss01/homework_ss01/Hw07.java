package com.ss01.homework_ss01;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "hw07", value = "/hw07")
public class Hw07 extends HttpServlet {
    private List<StudentTicket> studentList;

    @Override
    public void init() {
        studentList = new ArrayList<>();
        studentList.add(new StudentTicket("Lê Khánh Dương", "12A1", "Xe máy", "29A-12345"));
        studentList.add(new StudentTicket("Lê Khánh Linh", "12A2", "Xe đạp", "Không có"));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setAttribute("studentList", studentList);
        req.getRequestDispatcher("pages/hw07.jsp").forward(req, resp);
    }
}
