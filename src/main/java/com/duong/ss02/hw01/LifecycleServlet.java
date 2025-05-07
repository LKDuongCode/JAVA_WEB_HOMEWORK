package com.duong.ss02.hw01;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LifecycleServlet", value = "/lifecycle")
public class LifecycleServlet extends HttpServlet {
    private String title;

    @Override
    public void init() {
        title = "mô tả từng giai đoạn trong vòng đời của Servlet (init, service, destroy)".toUpperCase();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<h1>Yêu cầu bài 1: " + title + " </h1>");

        out.println("      <h2>Các giai đoạn:</h2> <br>\n" + "      <div>\n" + "        <p>loading:</p>\n" + "        <ul>\n" + "          <li>Container tải lớp và tạo instance Servlet (constructor không tham số)</li>\n" + "          <li>Tải khi web khởi động hoặc khi có yêu cầu đầu tiên.</li>\n" + "        </ul>\n" + "      </div>\n" + "\n" + "      <br>\n" + "      <div>\n" + "        <p>initializing : container gọi method init một lần duy nhất để khởi tạo Servlet</p>\n" + "      </div>\n" + "\n" + "      <br>\n" + "      <div>\n" + "        <p>handing request:</p>\n" + "        <ul>\n" + "          <li>1. tạo svRequest và svResponse</li>\n" + "          <li>2. gọi service(req, res) -> tự động điều hướng đến doGet(), doPost()</li>\n" + "        </ul>\n" + "      </div>\n" + "\n" + "      <br>\n" + "      <div>\n" + "        <p>destroying:</p>\n" + "        <ul>\n" + "          <li>chờ các request hoàn thành</li>\n" + "          <li>gọi destroy()  để giải phóng tài nguyên và cho phép bộ gom rác thu hồi bộ nhớ.</li>\n" + "        </ul>\n" + "      </div>");

    }

    public void destroy() {
    }
}

