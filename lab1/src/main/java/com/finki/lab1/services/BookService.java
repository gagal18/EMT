package com.finki.lab1.services;

import com.finki.lab1.model.Book;
import com.finki.lab1.model.UserBook;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> findAll();

    Optional<Book> save(Book book);

    Optional<Book> findById(Long id);

    Optional<Book> update(Long id, Book book);

    Optional<Book> deleteById(Long id);
    Optional<Book> reserveBook(Long id, UserBook user);
}
