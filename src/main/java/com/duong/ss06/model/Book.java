package com.duong.ss06.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private int id;
    private String title;
    private String author;
    private String category;
    private int quantity;

    //add
    public Book(int quantity, String category, String author, String title) {
        this.quantity = quantity;
        this.category = category;
        this.author = author;
        this.title = title;
    }
}
