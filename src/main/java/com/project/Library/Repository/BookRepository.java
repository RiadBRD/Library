package com.project.Library.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.Library.model.Book;

public interface BookRepository extends JpaRepository<Book, Long>{

}
