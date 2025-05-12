package com.duong.ss05.controller;


import com.duong.ss05.model.Post;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Hw09_Controller", value = {"/hw09", "/hw09/post"})
public class Hw09_Controller extends HttpServlet {

    private List<Post> posts = new ArrayList<>();

    @Override
    public void init() {
        posts.add(new Post(1, "how to change your info", "content 1...", "Admin", "2025-05-12"));
        posts.add(new Post(2, "AI maybe destroying people", "content 2...", "Duong", "2025-05-11"));
        posts.add(new Post(3, "stack overflow", "content 3...", "User", "2025-05-10"));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();
        String action = req.getServletPath() + (req.getPathInfo() != null ? req.getPathInfo() : "");

        if ("/hw09/post".equals(path)) {
            int id = Integer.parseInt(req.getParameter("id"));
            Post post = posts.stream().filter(p -> p.getId() == id).findFirst().orElse(null);

            if (post != null) {
                req.setAttribute("post", post);
                req.getRequestDispatcher("/views/hw09_post_detail.jsp").forward(req, resp);
            } else {
                resp.sendRedirect(req.getContextPath() + "/hw09");
            }
        } else {
            req.setAttribute("posts", posts);
            req.getRequestDispatcher("/views/hw09_posts.jsp").forward(req, resp);
        }
    }
}
