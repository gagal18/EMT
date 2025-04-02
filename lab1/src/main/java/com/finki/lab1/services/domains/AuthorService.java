package com.finki.lab1.services.domains;

import com.finki.lab1.dto.CreateAuthorDTO;
import com.finki.lab1.model.domains.Author.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    List<Author> findAll();

    Optional<Author> save(CreateAuthorDTO author);

    Optional<Author> findById(Long id);

    Optional<Author> update(Long id, Author author);

    Optional<Author> deleteById(Long id);
}
