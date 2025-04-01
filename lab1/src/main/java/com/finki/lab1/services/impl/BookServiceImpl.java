package com.finki.lab1.services.impl;

import com.finki.lab1.model.Book;
import com.finki.lab1.repository.AuthorRepository;
import com.finki.lab1.services.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final AuthorRepository authorRepository;

    public BookServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Book> findAll() {
        return null;
    }

    @Override
    public Optional<Book> save(Book book) {
        return Optional.empty();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Book> update(Long id, Book book) {
        return Optional.empty();
    }

    @Override
    public void deleteById(Long id) {

    }
}
