package com.company.bookstore.controllers;

import com.company.bookstore.models.Book;
import com.company.bookstore.repositories.BookRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BookController.class)
class BookControllerTest {

    @Autowired
    private MockMvc mock;
    @MockBean
    private BookRepository bookRepo;

    private ObjectMapper mapper = new ObjectMapper();
    private Book testBook;

    @BeforeEach
    void setUp() {
        testBook = new Book();
        testBook.setId(1);
        testBook.setIsbn("9780547928227");
        testBook.setPrice(new BigDecimal(45.99));
        //testBook.setPublishDate(LocalDate.now());
        testBook.setTitle("The Hobbit");

    }

    @Test
    void addBookTest() throws Exception{
        String inJson = mapper.writeValueAsString(testBook);
        mock.perform(post("/books")
                        .content(inJson)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated());
    }

    @Test
    void getBooksByIdTest() throws Exception{
        mock.perform(get("/books/1"))
                .andDo(print())
                .andExpect(status().isOk());

    }

    @Test
    void getBooks() throws Exception {
        mock.perform(get("/books"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void updateBooks() throws Exception {
        testBook.setIsbn("900000000000");
        testBook.setPrice(new BigDecimal(99.99));
        // testBook.setPublishDate(LocalDate.now());
        testBook.setTitle("not The Hobbit");

        String inJason = mapper.writeValueAsString(testBook);

        mock.perform(put("/books")
                .content(inJason)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    @Test
    void deleteBookById() throws Exception {
        mock.perform(delete("/books/1"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    @Test
    void findBookByAuthorId() throws Exception{
        mock.perform(get("/books/author/2"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}