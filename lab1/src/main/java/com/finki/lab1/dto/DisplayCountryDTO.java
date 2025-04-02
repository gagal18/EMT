package com.finki.lab1.dto;

import com.finki.lab1.model.domains.Author.Author;
import com.finki.lab1.model.domains.Books.Book;
import com.finki.lab1.model.domains.Country.Country;
import com.finki.lab1.model.enums.Category;

public record DisplayCountryDTO(String name, String continent) {
    public static DisplayCountryDTO from(Country country) {
        return new DisplayCountryDTO(
                country.getName(),
                country.getContinent()
        );
    }

    public Country toContinent() {
        return new Country(name, continent);
    }

}



