package com.finki.lab1.model.domains.Books;

import com.finki.lab1.model.domains.Author.Author;
import com.finki.lab1.model.domains.User.User;
import com.finki.lab1.model.enums.Category;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Integer availableCopies;
    @OneToOne
    private Author author;


    @Enumerated(EnumType.STRING)
    private Category category;

    public Book() {
    }

    public Book(String name, Integer availableCopies, Author author, Category category) {
        this.name = name;
        this.availableCopies = availableCopies;
        this.author = author;
        this.category = category;
    }
}
