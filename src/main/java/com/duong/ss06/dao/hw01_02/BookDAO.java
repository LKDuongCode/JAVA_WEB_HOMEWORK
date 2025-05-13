package com.duong.ss06.dao.hw01_02;

import com.duong.ss06.model.Book;

import java.util.List;

public interface BookDAO {
    List<Book> getBooks ();
    boolean insert (Book b);
    boolean update (Book b);
    boolean delete (int id);
}
