package com.finki.lab1.services.domains;

import com.finki.lab1.model.domains.Books.Book;
import com.finki.lab1.model.domains.User.User;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> findAll();

    Optional<Book> save(Book book);

    Optional<Book> findById(Long id);

    Optional<Book> update(Long id, Book book);

    Optional<Book> deleteById(Long id);
    Optional<Book> reserveBook(Long id, User user);
}
