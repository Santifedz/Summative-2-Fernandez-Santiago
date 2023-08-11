package com.company.bookstore.controllers;

import com.company.bookstore.models.Publisher;
import com.company.bookstore.repositories.PublisherRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.HashSet;

@WebMvcTest(PublisherController.class)
class PublisherControllerTest {
    @MockBean
    private PublisherRepository publisherepo;

    @Autowired
    private MockMvc mockMvc;

    ObjectMapper mapper = new ObjectMapper();

    @Test
    void getAllPublishers() throws Exception {
        mockMvc.perform(get("/publishers"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void getPublisherById() throws Exception{
        mockMvc.perform(get("/publishers/1"))
                .andDo(print())
                .andExpect(status().isOk());
    }


    @Test
    void createPublisher() throws Exception {
        Publisher publisher = new Publisher();

        publisher.setPublisherId(111);
        publisher.setPublisherName("George smith");
        //publisher.setname("Smith");
        publisher.setCity("Weehawken");
        publisher.setEmail("gsmith@gmail.com");
        publisher.setPhone("201-203-3894");
        publisher.setState("NJ");
        publisher.setPostalCode("08370");
        publisher.setStreet("Palisade street");


        String input = mapper.writeValueAsString(publisher);

        mockMvc.perform(post("/publishers")
                        .content(input)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated());
    }


    @Test
    void updatePublisher() throws Exception{
        Publisher updatedPublisher = new Publisher();

        updatedPublisher.setPublisherId(1);
        updatedPublisher.setPublisherName("George smith");
        //updatedPublisher.setname("Smith");
        updatedPublisher.setCity("Weehawken");
        updatedPublisher.setEmail("gsmith@gmail.com");
        updatedPublisher.setPhone("201-203-3894");
        updatedPublisher.setState("NJ");
        updatedPublisher.setPostalCode("08370");
        updatedPublisher.setStreet("Palisade street");

        String input = mapper.writeValueAsString(updatedPublisher);

        mockMvc.perform(post("/publishers")
                        .content(input).contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated());
    }


    @Test
    void deletePublisher() throws Exception {
        mockMvc.perform(delete("/publishers/1"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }
}



