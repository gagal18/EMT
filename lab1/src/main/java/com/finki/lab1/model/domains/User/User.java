package com.finki.lab1.model.domains.User;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.finki.lab1.model.domains.Books.Book;
import com.finki.lab1.model.enums.Role;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @JsonIgnore
    private String password;

    private String username;
    private String name;

    private String surname;

    @Enumerated(value = EnumType.STRING)
    private Role role;
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Book> books;

    public User() {
    }

    public User(String username, String password, String name, String surname, Role role) {
        this.password = password;
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.role = role;
    }

    public User(String username, String password, String name, String surname) {
        this.password = password;
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.role = Role.ROLE_USER;
    }
    public User (UserDetails userDetails) {
        this.username = userDetails.getUsername();
        this.password = userDetails.getPassword();
    }


}
