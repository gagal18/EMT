package com.finki.lab1.dto;

import com.finki.lab1.model.domains.Author.Author;
import com.finki.lab1.model.domains.Books.Book;
import com.finki.lab1.model.domains.Country.Country;
import com.finki.lab1.model.enums.Category;

public record CreateAuthorDTO(String name, String surname, Country country){
    public Author toAuthor() {
        return new Author(name, surname, country);
    }
}

