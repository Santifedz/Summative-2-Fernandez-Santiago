package com.company.bookstore.controllers;

import com.company.bookstore.models.Author;
import com.company.bookstore.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AuthorController {
    @Autowired
    AuthorRepository repo;

    // create
    @PostMapping("/authors")
    @ResponseStatus(HttpStatus.CREATED)
    public Author addAuthor(@RequestBody Author a){
        return repo.save(a);
    }

    // read by id
    @GetMapping("/authors/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Author getAuthorByID(@PathVariable int id) {
        Optional<Author> a = repo.findById(id);
        if(a.isEmpty()) { // if empty then return null
            return null;
        }else { // customer not empty, so it was found
            return a.get();
        }
    }

    // read all
    @GetMapping("/authors")
    @ResponseStatus(HttpStatus.OK)
    public List<Author> getAllAuthors(){
        return repo.findAll();
    }

    // update
    @PutMapping("/authors/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateAuthor(@RequestBody Author a){
        repo.save(a);
    }

    // delete
    @DeleteMapping("/authors/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAuthorById(@PathVariable int id){
        repo.deleteById(id);
    }


}
