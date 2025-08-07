package com.project.Library.service;

import java.util.List;

import com.project.Library.model.Book;

public interface BookService {
    Book createBook(Book book);

    List<Book> getBooksByAuthor(String author);

    List<Book> getAllBooks();

}
