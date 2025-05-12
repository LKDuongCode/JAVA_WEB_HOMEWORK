package com.duong.ss05.controller;

import com.duong.ss05.model.Task;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Hw08_Controller", value = "/hw08")
public class Hw08_Controller extends HttpServlet {

    private List<Task> tasks = new ArrayList<>();
    private int nextId = 1;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) action = "list";

        switch (action) {
            case "add":
                req.getRequestDispatcher("/views/hw08_task_form.jsp").forward(req, resp);
                break;

            case "edit":
                int editId = Integer.parseInt(req.getParameter("id"));
                Task taskToEdit = tasks.stream().filter(t -> t.getId() == editId).findFirst().orElse(null);
                if (taskToEdit != null) {
                    req.setAttribute("task", taskToEdit);
                    req.getRequestDispatcher("/views/hw08_task_form.jsp").forward(req, resp);
                } else {
                    resp.sendRedirect(req.getContextPath() + "/hw08");
                }
                break;

            default:
                req.setAttribute("tasks", tasks);
                req.getRequestDispatcher("/views/hw08_tasks.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        if ("create".equals(action)) {
            String description = req.getParameter("description");
            String dueDate = req.getParameter("dueDate");
            Task newTask = new Task(nextId++, description, dueDate, false);
            tasks.add(newTask);
            resp.sendRedirect(req.getContextPath() + "/hw08");

        } else if ("update".equals(action)) {
            int id = Integer.parseInt(req.getParameter("id"));
            for (Task task : tasks) {
                if (task.getId() == id) {
                    task.setDescription(req.getParameter("description"));
                    task.setDueDate(req.getParameter("dueDate"));
                    task.setCompleted(req.getParameter("completed") != null);
                    break;
                }
            }
            resp.sendRedirect(req.getContextPath() + "/hw08");

        } else if ("delete".equals(action)) {
            int id = Integer.parseInt(req.getParameter("id"));
            tasks.removeIf(t -> t.getId() == id);
            resp.sendRedirect(req.getContextPath() + "/hw08");
        }
    }
}
