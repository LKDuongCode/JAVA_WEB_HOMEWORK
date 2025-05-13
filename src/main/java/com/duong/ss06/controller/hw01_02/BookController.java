package com.duong.ss06.controller.hw01_02;

import com.duong.ss06.model.Book;
import com.duong.ss06.service.hw01_02.BookService;
import com.duong.ss06.service.hw01_02.BookServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@WebServlet(name = "BookController", value = "/book")
public class BookController extends HttpServlet {
    private final BookService bookService = new BookServiceImpl();

    List<Book> books = new ArrayList<>();

    @Override
    public void init() {
        books = bookService.getBooks();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            resp.sendRedirect(req.getContextPath() + "/auth?action=login");
            return;
        }

        String action = req.getParameter("action");
        switch (action) {
            case "list":
                books = bookService.getBooks();
                req.setAttribute("books",books);
                req.getRequestDispatcher("/views/listBook.jsp").forward(req,resp);
                break;
            case "add":
                req.getRequestDispatcher("/views/formAddBook.jsp").forward(req,resp);
                break;
            case "edit":
                books = bookService.getBooks();
                int code = Integer.parseInt(req.getParameter("code"));
                Optional<Book> b = books.stream()
                                .filter(book -> book.getId() == code).findFirst();
                if(b.isEmpty()){
                    req.setAttribute("errorMessage","edit code not found!");
                    req.getRequestDispatcher("/views/error.jsp").forward(req,resp);
                    break;
                }

                req.setAttribute("edit_book",b.get());
                req.getRequestDispatcher("/views/formEditBook.jsp").forward(req,resp);
                break;
            case "delete":
                int deleteCode = Integer.parseInt(req.getParameter("code"));
                bookService.deleteBook(deleteCode);
                resp.sendRedirect(req.getContextPath() + "/book?action=list");
                break;
            default:
                System.err.println("lỗi action get");
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        switch (action){
            case "create":
                Book b = extractBook(req,false);
                Optional<Book> result = bookService.addNewBook(b);
                if(result.isEmpty()){
                    req.setAttribute("errorMessage","add new book failed!");
                    req.getRequestDispatcher("/views/error.jsp").forward(req,resp);
                    break;
                }
                resp.sendRedirect(req.getContextPath() + "/book?action=list");
                break;
            case "edit":
                Book editBook = extractBook(req,true);
                Optional<Book> resultEdit = bookService.editBook(editBook);
                if(resultEdit.isEmpty()){
                    req.setAttribute("errorMessage","edit book failed!");
                    req.getRequestDispatcher("/views/error.jsp").forward(req,resp);
                    break;
                }
                resp.sendRedirect(req.getContextPath() + "/book?action=list");
                break;
            default:
                System.err.println("lỗi action post");
                break;
        }
    }

    @Override
    public void destroy() {
        super.destroy();
    }

    public Book extractBook (HttpServletRequest req, boolean isIncludedID){
        String title = req.getParameter("title");
        String author = req.getParameter("author");
        String category = req.getParameter("category");
        int quantity;
        try {
            quantity = Integer.parseInt(req.getParameter("quantity"));
        }catch (Exception e){
            quantity = -1;
            System.err.println(e.getMessage());
        }

        if(isIncludedID){
            int id;
            try {
                 id = Integer.parseInt(req.getParameter("id"));
            }catch (Exception e){
                id = -1;
                System.err.println("Lỗi bất định " + e.getMessage());
            }

            return new Book(id,title,author,category,quantity);
        }else{
            return new Book(quantity,category,author,title);
        }
    }
}
