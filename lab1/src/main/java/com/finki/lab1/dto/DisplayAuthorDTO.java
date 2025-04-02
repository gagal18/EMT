package com.finki.lab1.dto;

import com.finki.lab1.model.domains.Author.Author;
import com.finki.lab1.model.domains.Country.Country;

public record DisplayAuthorDTO(String name, String surname, Country country) {
    public static DisplayAuthorDTO from(Author author) {
        return new DisplayAuthorDTO(
                author.getName(),
                author.getSurname(),
                author.getCountry()
        );
    }

    public Author toAuthor() {
        return new Author(name, surname, country);
    }

}



