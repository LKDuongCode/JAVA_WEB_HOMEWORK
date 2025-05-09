package com.duong.ss04;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Hw06_StudentServlet", value = "/hw06")
public class Hw06_StudentServlet extends HttpServlet {

    private List<Hw06_Student> students;

    @Override
    public void init() {
        students = new ArrayList<>();
        students.add(new Hw06_Student("S01", "Lê Khánh Dương", 20, 8.5));
        students.add(new Hw06_Student("S02", "Trần Văn Vương", 21, 6.8));
        students.add(new Hw06_Student("S03", "Nguyễn Thị nở", 22, 7.2));
        students.add(new Hw06_Student("S04", "ledientien", 19, 3.0));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("students", students);
        req.getRequestDispatcher("hw06_studentList.jsp").forward(req, resp);
    }
}
