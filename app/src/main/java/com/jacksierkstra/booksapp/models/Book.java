package com.jacksierkstra.booksapp.models;

import com.orm.SugarRecord;

/**
 * Created by JackS on 27-3-2015.
 */
public class Book extends SugarRecord<Book>{
    String title;
    String isbn;

    public Book() {}

    public Book(String title, String isbn) {
        this.title = title;
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return this.title;
    }
}
