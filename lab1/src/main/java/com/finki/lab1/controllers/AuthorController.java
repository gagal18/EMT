package com.finki.lab1.controllers;

import com.finki.lab1.model.Author;
import com.finki.lab1.model.Country;
import com.finki.lab1.services.AuthorService;
import com.finki.lab1.services.CountryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/authors")

public class AuthorController {
    private final AuthorService authorService;
    private final CountryService countryService;

    public AuthorController(AuthorService authorService, CountryService countryService) {

        this.authorService = authorService;
        this.countryService = countryService;
    }

    @GetMapping
    public List<Author> findAll() {
        return authorService.findAll();
    }

    @PostMapping
    public Author create(@RequestParam String name, @RequestParam String surname, @RequestParam Long countryId){
        Country country = this.countryService.findById(countryId).orElseThrow();
        Author a = new Author(name, surname, country);
        return this.authorService.save(a).orElseThrow();
    }

}
