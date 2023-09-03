package com.company.bookstore.repositories;

import com.company.bookstore.models.Publisher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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

        publisher.setName("George smith");
        //publisher.setname("Smith");
        publisher.setCity("Weehawken");
        publisher.setEmail("gsmith@gmail.com");
        publisher.setPhone("201-203-3894");
        publisher.setState("NJ");
        publisher.setPostalCode("08370");
        publisher.setStreet("Palisade street");

        publisher = pubRepo.save(publisher);

        List<Publisher> publishers = pubRepo.findAll();
        assertEquals(1,publishers.size());
    }


    @Test
    void getAllPublishersById(){
        Publisher publisher = new Publisher();
        publisher.setName("George smith");
        //publisher.setname("Smith");
        publisher.setCity("Weehawken");
        publisher.setEmail("gsmith@gmail.com");
        publisher.setPhone("201-203-3894");
        publisher.setState("NJ");
        publisher.setPostalCode("08370");
        publisher.setStreet("Palisade street");

        publisher = pubRepo.save(publisher);

        Optional<Publisher> publisher2 = pubRepo.findById(publisher.getId());
        assertEquals(publisher2.get(),publisher);
    }

    @Test
    void createPublisher() {
        Publisher publisher = new Publisher();

        publisher.setName("George smith");
        //publisher.setname("Smith");
        publisher.setCity("Weehawken");
        publisher.setEmail("gsmith@gmail.com");
        publisher.setPhone("201-203-3894");
        publisher.setState("NJ");
        publisher.setPostalCode("08370");
        publisher.setStreet("Palisade street");

        pubRepo.save(publisher);

        Optional<Publisher> publisher2 = pubRepo.findById(publisher.getId());

        assertTrue(publisher2.isPresent());
        assertEquals(publisher2.get(), publisher);
    }


    @Test
    void updatePublisher() {
        Publisher updatedPublisher = new Publisher();
        updatedPublisher.setId(1);
        updatedPublisher.setName("George smith");
        //updatedPublisher.setname("Smith");
        updatedPublisher.setCity("Weehawken");
        updatedPublisher.setEmail("gsmith@gmail.com");
        updatedPublisher.setPhone("201-203-3894");
        updatedPublisher.setState("NJ");
        updatedPublisher.setPostalCode("08370");
        updatedPublisher.setStreet("Palisade street");
        updatedPublisher = pubRepo.save(updatedPublisher);

        updatedPublisher = pubRepo.save(updatedPublisher);

        updatedPublisher.setName("UPDATED");

        pubRepo.save(updatedPublisher);

        Optional<Publisher> publisher2 = pubRepo.findById(updatedPublisher.getId());
        assertEquals(publisher2.get(),updatedPublisher);
    }

    //Should delete publisher by id
    @Test
    void deletePublisher(){
        Publisher publisher = new Publisher();

        publisher.setId(111);
        publisher.setName("George smith");
        //publisher.setname("Smith");
        publisher.setCity("Weehawken");
        publisher.setEmail("gsmith@gmail.com");
        publisher.setPhone("201-203-3894");
        publisher.setState("NJ");
        publisher.setPostalCode("08370");
        publisher.setStreet("Palisade street");

        publisher = pubRepo.save(publisher);

        pubRepo.deleteById(publisher.getId());

        Optional<Publisher> publisher2 = pubRepo.findById(publisher.getId());
        assertFalse(publisher2.isPresent());
    }
}