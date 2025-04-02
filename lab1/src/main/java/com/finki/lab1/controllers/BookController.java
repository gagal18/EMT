package com.finki.lab1.controllers;

import com.finki.lab1.controllers.utils.ResponseEntityWrapper;
import com.finki.lab1.model.domains.Books.Book;
import com.finki.lab1.model.domains.User.User;
import com.finki.lab1.services.domains.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
    @GetMapping
    public List<Book> findAll() {
        return bookService.findAll();
    }

    @PostMapping
    public ResponseEntity<Book> create(@RequestBody Book book) {
        return ResponseEntityWrapper.createResponse(this.bookService.save(book).orElseThrow());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        Optional<Book> a = this.bookService.findById(id);
        return ResponseEntityWrapper.createResponse(a);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book book) {
        Optional<Book> a = this.bookService.update(id, book);
        return ResponseEntityWrapper.createResponse(a);
    }

    @PostMapping("/reserve/{id}")
    public ResponseEntity<Book> reserveBook(@PathVariable Long id, @RequestBody User user) {
        System.out.println(user);
        return ResponseEntityWrapper.createResponse(this.bookService.reserveBook(id,user).orElseThrow());
    }
    @PostMapping("/return/{id}")
    public ResponseEntity<Book> returnBook(@PathVariable Long id, @RequestBody User user) {
        return ResponseEntityWrapper.createResponse(this.bookService.reserveBook(id,user).orElseThrow());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Book> deleteBook(@PathVariable Long id) {
        Optional<Book> a = this.bookService.deleteById(id);
        return ResponseEntityWrapper.createResponse(a);
    }
}
