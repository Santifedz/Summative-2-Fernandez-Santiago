package com.company.bookstore.repositories;

import com.company.bookstore.models.Author;
import com.company.bookstore.models.Book;
import com.company.bookstore.models.Publisher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookRepositoryTest {
    @Autowired
    BookRepository bookRepo;

    @Autowired
    PublisherRepository publisherRepo;

    @Autowired
    AuthorRepository authorRepo;

    @BeforeEach
    public void setUp() throws Exception{
        bookRepo.deleteAll();
        publisherRepo.deleteAll();
        authorRepo.deleteAll();
    }

    @Test
    public void shouldCreateBook(){

        Publisher publisher = new Publisher();
        publisher.setPublisherName("random publisher");
        publisher.setCity("Chicago");
        publisher.setState("Il");
        publisher.setStreet("47 Gardner St");
        publisher.setPostalCode("60965");
        publisher.setEmail("contact@randomhouse.com");
        publisher.setPhone("1800-7560-4857");

        Author author = new Author();
        author.setFirstName("John");
        author.setLastName("Doe");
        author.setPostal_code("02134");
        author.setState("MA");
        author.setCity("Boston");
        author.setEmail("JDoe@gmail.com");
        author.setStreet("47 Garden St");

        Book book = new Book();
        book.setPublisher(publisher);
        book.setAuthor(author);
        book.setTitle("The Hobbit");
        book.setPrice(59.99);
        book.setIsbn("9780547928227");
        book.setPublishDate(LocalDate.now());

        publisher = publisherRepo.save(publisher);
        author = authorRepo.save(author);
        book = bookRepo.save(book);

        Optional<Book> foundBooks = bookRepo.findById(book.getBookId());
        assertEquals(foundBooks.get(), book);
    }

    @Test
    public void shouldReadBookById(){

        Publisher publisher = new Publisher();
        publisher.setPublisherName("random publisher");
        publisher.setCity("Chicago");
        publisher.setState("Il");
        publisher.setStreet("47 Gardner St");
        publisher.setPostalCode("60965");
        publisher.setEmail("contact@randomhouse.com");
        publisher.setPhone("1800-7560-4857");

        Author author = new Author();
        author.setFirstName("John");
        author.setLastName("Doe");
        author.setPostal_code("02134");
        author.setState("MA");
        author.setCity("Boston");
        author.setEmail("JDoe@gmail.com");
        author.setStreet("47 Garden St");

        Book book = new Book();
        book.setPublisher(publisher);
        book.setAuthor(author);
        book.setTitle("The Hobbit");
        book.setPrice(59.99);
        book.setIsbn("9780547928227");
        book.setPublishDate(LocalDate.now());

        publisher = publisherRepo.save(publisher);
        author = authorRepo.save(author);
        book = bookRepo.save(book);

        Optional<Book> foundBooks = bookRepo.findById(book.getBookId());
        assertEquals(foundBooks.get(), book);
    }

    @Test
    public void shouldReadAll(){

        Publisher publisher = new Publisher();
        publisher.setPublisherName("random publisher");
        publisher.setCity("Chicago");
        publisher.setState("Il");
        publisher.setStreet("47 Gardner St");
        publisher.setPostalCode("60965");
        publisher.setEmail("contact@randomhouse.com");
        publisher.setPhone("1800-7560-4857");

        Author author = new Author();
        author.setFirstName("John");
        author.setLastName("Doe");
        author.setPostal_code("02134");
        author.setState("MA");
        author.setCity("Boston");
        author.setEmail("JDoe@gmail.com");
        author.setStreet("47 Garden St");

        Book book = new Book();
        book.setPublisher(publisher);
        book.setAuthor(author);
        book.setTitle("The Hobbit");
        book.setPrice(59.99);
        book.setIsbn("9780547928227");
        book.setPublishDate(LocalDate.now());

        publisher = publisherRepo.save(publisher);
        author = authorRepo.save(author);
        book = bookRepo.save(book);

        publisher = new Publisher();
        publisher.setPublisherName("random publisher");
        publisher.setCity("Chicago");
        publisher.setState("Il");
        publisher.setStreet("47 Gardner St");
        publisher.setPostalCode("60965");
        publisher.setEmail("contact@randomhouse.com");
        publisher.setPhone("1800-7560-4857");

        author = new Author();
        author.setFirstName("John");
        author.setLastName("Doe");
        author.setPostal_code("02134");
        author.setState("MA");
        author.setCity("Boston");
        author.setEmail("JDoe@gmail.com");
        author.setStreet("47 Garden St");

        book = new Book();
        book.setPublisher(publisher);
        book.setAuthor(author);
        book.setTitle("The Hobbit");
        book.setPrice(59.99);
        book.setIsbn("9780547928227");
        book.setPublishDate(LocalDate.now());

        publisher = publisherRepo.save(publisher);
        author = authorRepo.save(author);
        book = bookRepo.save(book);

        List<Book> bookList = bookRepo.findAll();

        assertEquals(bookList.size(), 2);
    }

    @Test
    public void shouldUpdateBook(){
        Publisher publisher = new Publisher();
        publisher.setPublisherName("random publisher");
        publisher.setCity("Chicago");
        publisher.setState("Il");
        publisher.setStreet("47 Gardner St");
        publisher.setPostalCode("60965");
        publisher.setEmail("contact@randomhouse.com");
        publisher.setPhone("1800-7560-4857");

        Author author = new Author();
        author.setFirstName("John");
        author.setLastName("Doe");
        author.setPostal_code("02134");
        author.setState("MA");
        author.setCity("Boston");
        author.setEmail("JDoe@gmail.com");
        author.setStreet("47 Garden St");

        Book book = new Book();
        book.setPublisher(publisher);
        book.setAuthor(author);
        book.setTitle("The Hobbit");
        book.setPrice(59.99);
        book.setIsbn("9780547928227");
        book.setPublishDate(LocalDate.now());

        publisher = publisherRepo.save(publisher);
        author = authorRepo.save(author);
        book = bookRepo.save(book);

        book.setTitle("Not The Hobbit");
        book.setPrice(0.99);
        book.setIsbn("00000000");
        book.setPublishDate(LocalDate.now());

        book = bookRepo.save(book);

        Optional<Book> foundBooks = bookRepo.findById(book.getBookId());
        assertEquals(foundBooks.get(), book);
    }


    @Test
    public void shouldDeleteByBookId(){
        Publisher publisher = new Publisher();
        publisher.setPublisherName("random publisher");
        publisher.setCity("Chicago");
        publisher.setState("Il");
        publisher.setStreet("47 Gardner St");
        publisher.setPostalCode("60965");
        publisher.setEmail("contact@randomhouse.com");
        publisher.setPhone("1800-7560-4857");

        Author author = new Author();
        author.setFirstName("John");
        author.setLastName("Doe");
        author.setPostal_code("02134");
        author.setState("MA");
        author.setCity("Boston");
        author.setEmail("JDoe@gmail.com");
        author.setStreet("47 Garden St");

        Book book = new Book();
        book.setPublisher(publisher);
        book.setAuthor(author);
        book.setTitle("The Hobbit");
        book.setPrice(59.99);
        book.setIsbn("9780547928227");
        book.setPublishDate(LocalDate.now());

        publisher = publisherRepo.save(publisher);
        author = authorRepo.save(author);
        book = bookRepo.save(book);

        bookRepo.deleteById(book.getBookId());
        Optional<Book> foundBooks = bookRepo.findById(book.getBookId());

        assertFalse(foundBooks.isPresent());
    }


    @Test
    public void shouldGetBookByAuthorId() {

        Publisher publisher = new Publisher();
        publisher.setPublisherName("random publisher");
        publisher.setCity("Chicago");
        publisher.setState("Il");
        publisher.setStreet("47 Gardner St");
        publisher.setPostalCode("60965");
        publisher.setEmail("contact@randomhouse.com");
        publisher.setPhone("1800-7560-4857");
        publisher = publisherRepo.save(publisher);


        Author author = new Author();
        author.setFirstName("John");
        author.setLastName("Doe");
        author.setPostal_code("02134");
        author.setState("MA");
        author.setCity("Boston");
        author.setEmail("JDoe@gmail.com");
        author.setStreet("47 Garden St");
        author = authorRepo.save(author);

        Book book = new Book();
        book.setPublisher(publisher);
        book.setAuthor(author);
        book.setTitle("The Hobbit");
        book.setPrice(59.99);
        book.setIsbn("9780547928227");
        book.setPublishDate(LocalDate.now());
        book = bookRepo.save(book);

        List<Book> bookList = bookRepo.findByAuthorId(author.getId());

        assertEquals(bookList.size(),1);
    }
}