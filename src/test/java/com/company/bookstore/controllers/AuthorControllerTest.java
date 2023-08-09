package com.company.bookstore.controllers;

import com.company.bookstore.models.Author;
import com.company.bookstore.repositories.AuthorRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import static javax.swing.UIManager.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AuthorController.class)
public class AuthorControllerTest {
    // Wiring in the MockMvc object
    @Autowired
    MockMvc mockMvc;
    // ObjectMapper used to convert Java objects to JSON and vice versa
    private ObjectMapper mapper = new ObjectMapper();

    @MockBean
    AuthorRepository repo;
    Author a;

    @BeforeEach
    public void setUp() {
        repo.deleteAll();
        a = new Author();
        a.setId(1);
        a.setFirstName("Jeff");
        a.setLastName("Bob");
    }

    //Create
    @Test
    public void createAuthorTest() throws Exception {
        String inputJson = mapper.writeValueAsString(a);
        mockMvc.perform(post("/authors")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    //Read by Id
    @Test
    public void getAuthorByIDTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/authors/1"))
                .andExpect(status().isOk());
    }



    //Read All
    @Test
    public void getAllAuthorsTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/authors"))
                .andExpect(status().isOk());
    }

    //Update
    @Test
    public void updateAuthorTest() throws Exception {
        String inputJson = mapper.writeValueAsString(a);
        mockMvc.perform(put("/authors/{id}", a.getId())
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }


    //Delete
    @Test
    public void deleteAuthorTest() throws Exception {
        mockMvc.perform(delete("/authors/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }

}
