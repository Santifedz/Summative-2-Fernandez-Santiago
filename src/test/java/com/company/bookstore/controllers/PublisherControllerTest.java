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
    private MockMvc mock;

    ObjectMapper mapper = new ObjectMapper();

    @Test
    void getAllPublishers() throws Exception {
        mock.perform(get("/publishers"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void getPublisherById() throws Exception{
        mock.perform(get("/publisher/1"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    Publisher publisher = new Publisher();
    @Test
    void createPublisher() throws Exception {


        publisher.setPublisherId(1);
        publisher.setPublisherName("George smith");
        publisher.setCity("Weehawken");
        publisher.setEmail("gsmith@gmail.com");
        publisher.setPhone("201-203-3894");
        publisher.setState("NJ");
        publisher.setPostalCode("08370");
        publisher.setStreet("Palisade street");


        String input = mapper.writeValueAsString(publisher);

        mock.perform(post("/publisher")
                        .content(input)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated());
    }


    @Test
    void updatePublisher() throws Exception {
        publisher.setPublisherId(1);

        String input = mapper.writeValueAsString(publisher);

        mock.perform(put("/publishers/{id}", publisher.getPublisherId())
                        .content(input)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNoContent());
    }


    @Test
    void deletePublisher() throws Exception {
        mock.perform(delete("/publishers/1"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }
}



