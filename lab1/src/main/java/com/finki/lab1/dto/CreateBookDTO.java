package com.finki.lab1.dto;

import com.finki.lab1.model.domains.Author.Author;
import com.finki.lab1.model.domains.Books.Book;
import com.finki.lab1.model.enums.Category;

public record CreateBookDTO(String name, Integer availableCopies, Author author, Category category){
    public Book toBook() {
        return new Book(name, availableCopies, author, category);
    }
}

