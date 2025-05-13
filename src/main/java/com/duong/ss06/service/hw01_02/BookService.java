package com.duong.ss06.service.hw01_02;

import com.duong.ss06.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> getBooks ();
    Optional<Book> addNewBook (Book b);
    Optional<Book> editBook (Book b);
    boolean deleteBook (int id);
}
