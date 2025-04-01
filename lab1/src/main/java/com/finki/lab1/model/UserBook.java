package com.finki.lab1.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class UserBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @OneToMany
    private List<Book> books;
    public UserBook(String name) {
        this.name = name;
    }

    public UserBook() {
    }
}
