package com.project.Library.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.Library.exceptions.InvalidBookException;
import com.project.Library.model.Book;
import com.project.Library.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book createBook(Book book) throws InvalidBookException {
        if (book.getTitle().isEmpty() || book.getTitle().isBlank() || book.getTitle().equals("")) {
            throw new InvalidBookException("Le livre ne contient pas de titre");
        }

        return bookRepository.save(book);

    }

    @Override
    public List<Book> getBooksByAuthor(String author) {
        return this.bookRepository.findByAuthor(author);
    }

    @Override
    public List<Book> getAllBooks() {
        return this.bookRepository.findAll();
    }

}
