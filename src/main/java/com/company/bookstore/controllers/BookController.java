package com.company.bookstore.controllers;

import com.company.bookstore.models.Book;
import com.company.bookstore.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.List;

@RestController
public class BookController {
    @Autowired
    BookRepository bookRepository;

    // Create
    @PostMapping("/books")
    @ResponseStatus(HttpStatus.CREATED)
    public Book addBook(@RequestBody Book book){
        return bookRepository.save(book);
    }

    // Read by book id
    @GetMapping("/books/{bookId}")
    @ResponseStatus(HttpStatus.OK)
    public Book getBooksById(@PathVariable int bookId){
        Optional<Book> foundBooks = bookRepository.findById(bookId);
        if(foundBooks.isPresent()){
            return foundBooks.get();
        }else{
            return null;
        }
    }

    // Read all
    @GetMapping("/books")
    @ResponseStatus(HttpStatus.OK)
    public List<Book> getBooks(){
        return bookRepository.findAll();
    }

    // Update
    @PutMapping("/books")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateBooks(@RequestBody Book book){
        bookRepository.save(book);
    }

    // Delete
    @DeleteMapping("/books/{bookId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBookById(@PathVariable int bookId){
        bookRepository.deleteById(bookId);
    }

    // Read by author id
    @GetMapping("/books/author/{authorId}")
    public List<Book> findBookByAuthorId(@PathVariable int authorId){
        return bookRepository.findByAuthorId(authorId);
    }



}
