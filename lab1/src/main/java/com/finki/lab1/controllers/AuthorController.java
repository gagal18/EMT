package com.finki.lab1.controllers;

import com.finki.lab1.controllers.utils.ResponseEntityWrapper;
import com.finki.lab1.model.Author;
import com.finki.lab1.model.Country;
import com.finki.lab1.services.AuthorService;
import com.finki.lab1.services.CountryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public Author create(@RequestParam String name, @RequestParam String surname, @RequestParam Long countryId) {
        Country country = this.countryService.findById(countryId).orElseThrow();
        return this.authorService.save(new Author(name, surname, country)).orElseThrow();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Author> getAuthorById(@PathVariable Long id) {
        Optional<Author> a = this.authorService.findById(id);
        return ResponseEntityWrapper.createResponse(a);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Author> updateAuthor(@PathVariable Long id, @RequestBody Author author) {
        Optional<Author> a = this.authorService.update(id, author);
        return ResponseEntityWrapper.createResponse(a);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Author> deleteAuthor(@PathVariable Long id) {
        Optional<Author> a = this.authorService.deleteById(id);
        return ResponseEntityWrapper.createResponse(a);
    }
}