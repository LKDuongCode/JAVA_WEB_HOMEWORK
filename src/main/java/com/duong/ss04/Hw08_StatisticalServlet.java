package com.duong.ss04;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Hw08_StatisticalServlet", value = "/hw08")
public class Hw08_StatisticalServlet extends HttpServlet {

    private List<Hw08_Revenue> revenues;

    @Override
    public void init() {
        revenues = new ArrayList<>();
        revenues.add(new Hw08_Revenue("January", 2500));
        revenues.add(new Hw08_Revenue("February", 1800));
        revenues.add(new Hw08_Revenue("March", 3000));
        revenues.add(new Hw08_Revenue("April", 2700));
        revenues.add(new Hw08_Revenue("May", 1500));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("revenues", revenues);
        req.getRequestDispatcher("hw08_statistical.jsp").forward(req, resp);
    }
}
