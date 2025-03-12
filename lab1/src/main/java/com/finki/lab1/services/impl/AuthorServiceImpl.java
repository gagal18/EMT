package com.finki.lab1.services.impl;

import com.finki.lab1.models.Author;
import com.finki.lab1.repository.AuthorRepository;
import com.finki.lab1.services.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public Optional<Author> save(Author author) {
        return Optional.empty();
    }

    @Override
    public Optional<Author> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Author> update(Long id, Author author) {
        return Optional.empty();
    }

    @Override
    public void deleteById(Long id) {

    }
}
