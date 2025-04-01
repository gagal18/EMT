package com.finki.lab1.services.impl;

import com.finki.lab1.model.Author;
import com.finki.lab1.model.Book;
import com.finki.lab1.model.UserBook;
import com.finki.lab1.repository.BookRepository;
import com.finki.lab1.services.BookService;
import org.apache.catalina.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public Optional<Book> save(Book book) {
        return Optional.of(bookRepository.save(book));
    }

    @Override
    public Optional<Book> update(Long id, Book book) {
        Optional<Book> exsistingBook = bookRepository.findById(id);

        if (exsistingBook.isPresent()) {
            Book bookToUpdate = exsistingBook.get();
            bookToUpdate.setName(bookToUpdate.getName());
            bookToUpdate.setAuthor(bookToUpdate.getAuthor());
            bookToUpdate.setCategory(bookToUpdate.getCategory());
            bookToUpdate.setAvailableCopies(bookToUpdate.getAvailableCopies());

            bookRepository.save(bookToUpdate);
            return Optional.of(bookToUpdate);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public Optional<Book> deleteById(Long id) {
        Optional<Book> exsistingBook = bookRepository.findById(id);
        if (exsistingBook.isPresent()) {
            bookRepository.deleteById(id);
            return exsistingBook;
        }else{
            return Optional.empty();
        }
    }

    @Override
    public Optional<Book> reserveBook(Long id, UserBook userBook) {
        Optional<Book> book = bookRepository.findById(id);
        if (book.isPresent()) {
            Book b = book.get();
            b.setAvailableCopies(b.getAvailableCopies() == 0 ? 0 : b.getAvailableCopies() - 1);
            List<UserBook> newUb = b.getUsers();
            if(newUb.contains(userBook)){
                newUb.remove(userBook);
            }else{
                newUb.add(userBook);
            }
            b.setUsers(newUb);
            Book nB = bookRepository.save(b);
            return Optional.of(nB);
        }else{
            return Optional.empty();
        }
    }

}
