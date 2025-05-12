package com.duong.ss05.controller;

import com.duong.ss05.model.Hw04_Student;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Hw04_Controller", value = {"/hw04", "/hw04/edit", "/hw04/delete"})
public class Hw04_Controller extends HttpServlet {

    private List<Hw04_Student> students;

    private static final int STUDENTS_PER_PAGE = 5;

    @Override
    public void init() {
        students = new ArrayList<>();
        for (int i = 1; i <= 23; i++) {
            students.add(new Hw04_Student(i, "Sinh Viên " + i, 20 + i % 5, "Địa chỉ " + i));
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();

        if ("/hw04/edit".equals(path)) {
            int id = Integer.parseInt(req.getParameter("id"));
            Hw04_Student studentToEdit = students.stream().filter(s -> s.getId() == id).findFirst().orElse(null);

            if (studentToEdit == null) {
                resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Không tìm thấy sinh viên");
                return;
            }

            req.setAttribute("student", studentToEdit);
            req.getRequestDispatcher("/views/hw04_edit.jsp").forward(req, resp);

        } else if ("/hw04/delete".equals(path)) {
            int id = Integer.parseInt(req.getParameter("id"));
            students.removeIf(s -> s.getId() == id);

            // Điều chỉnh khi xoá → chuyển về trang trước nếu cần
            int totalPages = (int) Math.ceil((double) students.size() / STUDENTS_PER_PAGE);
            int currentPage = Integer.parseInt(req.getParameter("page") != null ? req.getParameter("page") : "1");
            if (currentPage > totalPages) {
                currentPage = totalPages;
            }

            resp.sendRedirect(req.getContextPath() + "/hw04?page=" + currentPage);

        } else {
            int currentPage = 1;
            String pageParam = req.getParameter("page");
            if (pageParam != null) {
                try {
                    currentPage = Integer.parseInt(pageParam);
                } catch (NumberFormatException ignored) {}
            }

            int totalStudents = students.size();
            int totalPages = (int) Math.ceil((double) totalStudents / STUDENTS_PER_PAGE);

            if (currentPage < 1) currentPage = 1;
            if (currentPage > totalPages) currentPage = totalPages;

            int start = (currentPage - 1) * STUDENTS_PER_PAGE;
            int end = Math.min(start + STUDENTS_PER_PAGE, totalStudents);

            List<Hw04_Student> studentsPage = students.subList(start, end);

            req.setAttribute("students", studentsPage);
            req.setAttribute("currentPage", currentPage);
            req.setAttribute("totalPages", totalPages);

            req.getRequestDispatcher("/views/hw04_student.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));
        String address = req.getParameter("address");

        for (Hw04_Student student : students) {
            if (student.getId() == id) {
                student.setName(name);
                student.setAge(age);
                student.setAddress(address);
                break;
            }
        }

        resp.sendRedirect(req.getContextPath() + "/hw04");
    }
}
