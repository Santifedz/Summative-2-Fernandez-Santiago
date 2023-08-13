package com.company.bookstore.controllers;

import com.company.bookstore.models.Author;
import com.company.bookstore.models.Book;
import com.company.bookstore.models.Publisher;
import com.company.bookstore.repositories.AuthorRepository;
import com.company.bookstore.repositories.BookRepository;
import com.company.bookstore.repositories.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;
import org.springframework.graphql.data.method.annotation.Argument;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Optional;


@Controller
public class GraphController {
    @Autowired
    AuthorRepository authorRepo;
    @Autowired
    PublisherRepository publisherRepo;
    @Autowired
    BookRepository bookRepo;

    @QueryMapping
    public Author findAuthorById(@Argument Integer id){
        return authorRepo.findById(id).orElse(null);
    }

    @QueryMapping
    public Publisher findPublisherById(@Argument Integer id){
        return publisherRepo.findById(id).orElse(null);
    }

    @QueryMapping
    public Book findBookById(@Argument Integer id){
        return bookRepo.findById(id).orElse(null);
    }

    @SchemaMapping
    public Author author(Book book){
        return authorRepo.findById(book.getAuthor().getId()).orElse(null);
    }

    @SchemaMapping
    public Publisher publisher(Book book){
        return publisherRepo.findById(book.getPublisher().getPublisherId()).orElse(null);
    }

}
