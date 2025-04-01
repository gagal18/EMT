package com.finki.lab1.services;

import com.finki.lab1.model.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    List<Author> findAll();

    Optional<Author> save(Author author);

    Optional<Author> findById(Long id);

    Optional<Author> update(Long id, Author author);

    Optional<Author> deleteById(Long id);
}
