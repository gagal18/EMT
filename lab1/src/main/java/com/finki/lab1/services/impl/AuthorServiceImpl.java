package com.finki.lab1.services.impl;

import com.finki.lab1.model.Author;
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
        return Optional.of(authorRepository.save(author));
    }

    @Override
    public Optional<Author> findById(Long id) {
        return authorRepository.findById(id);
    }

    @Override
    public Optional<Author> update(Long id, Author author) {
        Optional<Author> existingAuthor = authorRepository.findById(id);

        if (existingAuthor.isPresent()) {
            Author updatedAuthor = existingAuthor.get();

            updatedAuthor.setName(author.getName());
            updatedAuthor.setCountry(author.getCountry());
            updatedAuthor.setSurname(author.getSurname());

            authorRepository.save(updatedAuthor);
            return Optional.of(updatedAuthor);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public void deleteById(Long id) {
        if (authorRepository.existsById(id)) {
            authorRepository.deleteById(id);
        }
    }
}
