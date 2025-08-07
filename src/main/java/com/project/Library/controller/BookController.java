package com.project.Library.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.project.Library.model.Book;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.project.Library.service.BookService;


@RestController
@RequestMapping("/api")
public class BookController {

    private final BookService bookService;

     public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/books")
    @ResponseStatus(HttpStatus.CREATED)

   
    public Book createBook(@RequestBody Book book) {
        return bookService.createBook(book);
    }
    
}
