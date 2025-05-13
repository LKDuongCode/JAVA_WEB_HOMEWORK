package com.duong.ss06.service.hw01_02;

import com.duong.ss06.dao.hw01_02.BookDAO;
import com.duong.ss06.dao.hw01_02.BookDaoImpl;
import com.duong.ss06.model.Book;

import java.util.List;
import java.util.Optional;

public class BookServiceImpl implements BookService{
    private final BookDAO bookDAO = new BookDaoImpl();
    @Override
    public List<Book> getBooks() {
        return bookDAO.getBooks();
    }

    @Override
    public Optional<Book> addNewBook(Book b) {
        if(bookDAO.insert(b)) return Optional.of(b);
        return Optional.empty();
    }

    @Override
    public Optional<Book> editBook(Book b) {
        if(bookDAO.update(b)) return Optional.of(b);
        return Optional.empty();
    }

    @Override
    public boolean deleteBook(int id) {
        return bookDAO.delete(id);
    }
}
