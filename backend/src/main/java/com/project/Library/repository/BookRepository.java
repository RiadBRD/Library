package com.project.Library.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.Library.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{
    List<Book> findByAuthor(String author);
}
