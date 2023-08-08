package com.company.bookstore.repositories;

import com.company.bookstore.models.Publisher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PublisherRepositoryTest {
    @Autowired
    PublisherRepository pubRepo;

    @Autowired
    BookRepository bookRepo;

    @BeforeEach
    void setUp() {
        pubRepo.deleteAll();
        bookRepo.deleteAll();
    }

    //Should get all publishers
    @Test
    void getAllPublishers(){
        Publisher publisher = new Publisher();

        publisher.setPublisherId(111);
        publisher.setPublisherName("George smith");
        publisher.setname("Smith");
        publisher.setCity("Weehawken");
        publisher.setEmail("gsmith@gmail.com");
        publisher.setPhone("201-203-3894");
        publisher.setState("NJ");
        publisher.setPostalCode("08370");
        publisher.setStreet("Palisade street");

        List<Publisher> publishers = pubRepo.findAll();
        assertEquals(1,publishers.size());
    }


    @Test
    void getAllPublishersById(){
        Publisher publisher = new Publisher();
        publisher.setPublisherId(111);
        publisher.setPublisherName("George smith");
        publisher.setname("Smith");
        publisher.setCity("Weehawken");
        publisher.setEmail("gsmith@gmail.com");
        publisher.setPhone("201-203-3894");
        publisher.setState("NJ");
        publisher.setPostalCode("08370");
        publisher.setStreet("Palisade street");

        publisher = pubRepo.save(publisher);

        Optional<Publisher> publisher2 = pubRepo.findById(publisher.getPublisherId());
        assertEquals(publisher2.get(),publisher);
    }

    //Should create a publisher
    @Test
    void createPublisher() {
        Publisher publisher = new Publisher();

        publisher.setPublisherId(111);
        publisher.setPublisherName("George smith");
        publisher.setname("Smith");
        publisher.setCity("Weehawken");
        publisher.setEmail("gsmith@gmail.com");
        publisher.setPhone("201-203-3894");
        publisher.setState("NJ");
        publisher.setPostalCode("08370");
        publisher.setStreet("Palisade street");

        Optional<Publisher> publisher2 = pubRepo.findById(publisher.getPublisherId());
        assertEquals(publisher2.get(), publisher);
    }


    @Test
    void updatePublisher() {
        Publisher updatedPublisher = new Publisher();
        updatedPublisher.setPublisherId(1);
        updatedPublisher.setPublisherName("George smith");
        updatedPublisher.setname("Smith");
        updatedPublisher.setCity("Weehawken");
        updatedPublisher.setEmail("gsmith@gmail.com");
        updatedPublisher.setPhone("201-203-3894");
        updatedPublisher.setState("NJ");
        updatedPublisher.setPostalCode("08370");
        updatedPublisher.setStreet("Palisade street");
        updatedPublisher = pubRepo.save(updatedPublisher);

        updatedPublisher = pubRepo.save(updatedPublisher);

        updatedPublisher.setPublisherName("UPDATED");

        pubRepo.save(updatedPublisher);

        Optional<Publisher> publisher2 = pubRepo.findById(updatedPublisher.getPublisherId());
        assertEquals(publisher2.get(),updatedPublisher);
    }

    //Should delete publisher by id
    @Test
    void deletePublisher(){
        Publisher publisher = new Publisher();

        publisher.setPublisherId(111);
        publisher.setPublisherName("George smith");
        publisher.setname("Smith");
        publisher.setCity("Weehawken");
        publisher.setEmail("gsmith@gmail.com");
        publisher.setPhone("201-203-3894");
        publisher.setState("NJ");
        publisher.setPostalCode("08370");
        publisher.setStreet("Palisade street");

        publisher = pubRepo.save(publisher);

        pubRepo.deleteById(publisher.getPublisherId());

        Optional<Publisher> publisher2 = pubRepo.findById(publisher.getPublisherId());
        assertFalse(publisher2.isPresent());
    }
}