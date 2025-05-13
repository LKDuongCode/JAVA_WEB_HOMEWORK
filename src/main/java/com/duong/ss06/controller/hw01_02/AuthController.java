package com.duong.ss06.controller.hw01_02;

import com.duong.ss06.model.User;
import com.duong.ss06.service.hw01_02.UserService;
import com.duong.ss06.service.hw01_02.UserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "AuthController", value = "/auth")
public class AuthController extends HttpServlet {
    private final UserService userService = new UserServiceImpl();

    @Override
    public void init(){
        //init
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);

        if (session != null && session.getAttribute("user") != null) {
            resp.sendRedirect(req.getContextPath() + "/book?action=list");
            return;
        }

        String action = req.getParameter("action");
        handleAction(req, resp, action);
    }

    private void handleAction(HttpServletRequest req, HttpServletResponse resp, String action) throws IOException, ServletException {
        if (action == null) {
            forwardError(req, resp, "Missing action in auth controller");
            return;
        }

        switch (action) {
            case "login":
                resp.sendRedirect(req.getContextPath() + "/views/login.jsp");
                break;
            case "register":
                resp.sendRedirect(req.getContextPath() + "/views/register.jsp");
                break;
            case "logout":
                resp.sendRedirect(req.getContextPath() + "/views/login.jsp");
                break;
            default:
                forwardError(req, resp, "Unknown action: " + action);
                break;
        }
    }

    private void forwardError(HttpServletRequest req, HttpServletResponse resp, String message) throws ServletException, IOException {
        req.setAttribute("errorMessage", message);
        req.getRequestDispatcher("/views/error.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        if ("register".equals(action)) {
            handleRegister(req, resp);
        } else if ("login".equals(action)) {
            handleLogin(req, resp);
        } else {
            req.setAttribute("errorMessage", "Invalid action in POST: " + action);
            req.getRequestDispatcher("/views/error.jsp").forward(req, resp);
        }
    }

    private void handleRegister(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String password = req.getParameter("password");

        if (userService.getUserByEmail(email).isPresent()) {
            req.setAttribute("errorMessage", "Email đã được sử dụng!");
            req.getRequestDispatcher("/views/register.jsp").forward(req, resp);
            return;
        }

        User newUser = new User(username, email, phone, password);
        boolean created = userService.createUser(newUser);

        if (created) {
            resp.sendRedirect(req.getContextPath() + "/auth?action=login");
        } else {
            req.setAttribute("errorMessage", "Đăng ký thất bại, thử lại sau.");
            req.getRequestDispatcher("/views/register.jsp").forward(req, resp);
        }
    }

    private void handleLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        Optional<User> optionalUser = userService.getUserByEmail(email);

        if (optionalUser.isPresent() && optionalUser.get().getPassword().equals(password)) {
            HttpSession session = req.getSession();
            session.setAttribute("user", optionalUser.get());
            resp.sendRedirect(req.getContextPath() + "/book?action=list");
        } else {
            req.setAttribute("errorMessage", "Email hoặc mật khẩu không chính xác!");
            req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
        }
    }



    @Override
    public void destroy() {
        super.destroy();
    }
}
