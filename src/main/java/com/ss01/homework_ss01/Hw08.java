package com.ss01.homework_ss01;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "hw08", value = "/hw08")
public class Hw08 extends HttpServlet {

    private List<Task> tasks;

    @Override
    public void init() {
        tasks = new ArrayList<>();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setAttribute("tasks", tasks);
        req.getRequestDispatcher("pages/hw08.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String title = req.getParameter("title");
        if (title != null && !title.trim().isEmpty()) {
            tasks.add(new Task(title, false));
        }

        String completeIndex = req.getParameter("complete");
        if (completeIndex != null) {
            int index = Integer.parseInt(completeIndex);
            if (index >= 0 && index < tasks.size()) {
                tasks.get(index).setCompleted(true);
            }
        }

        resp.sendRedirect("hw08");
    }
}