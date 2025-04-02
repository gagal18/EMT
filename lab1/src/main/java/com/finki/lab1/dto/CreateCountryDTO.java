package com.finki.lab1.dto;

import com.finki.lab1.model.domains.Author.Author;
import com.finki.lab1.model.domains.Books.Book;
import com.finki.lab1.model.domains.Country.Country;
import com.finki.lab1.model.enums.Category;

public record CreateCountryDTO(String name, String continent){
    public Country toCountry() {
        return new Country(name, continent);
    }
}

