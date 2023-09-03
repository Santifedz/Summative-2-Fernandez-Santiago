package com.company.bookstore.repositories;

import com.company.bookstore.models.Author;
import com.company.bookstore.models.Book;
import com.company.bookstore.models.Publisher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
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

    Book book;
    Publisher publisher;
    Author author;

    @BeforeEach
    public void setUp() throws Exception{
        bookRepo.deleteAll();
        publisherRepo.deleteAll();
        authorRepo.deleteAll();

        publisher = new Publisher();
        publisher.setName("random publisher");
        publisher.setCity("Chicago");
        publisher.setState("Il");
        publisher.setStreet("47 Gardner St");
        publisher.setPostalCode("60965");
        publisher.setEmail("contact@randomhouse.com");
        publisher.setPhone("1800-7560-4857");
        publisher = publisherRepo.save(publisher);

        author = new Author();
        author.setFirstName("John");
        author.setLastName("Doe");
        author.setPostalCode("02134");
        author.setState("MA");
        author.setCity("Boston");
        author.setEmail("JDoe@gmail.com");
        author.setStreet("47 Garden St");
        author.setPhone("512-933-0234");
        author = authorRepo.save(author);

        book = new Book();
        book.setPublisherId(publisher.getId());
        book.setAuthorId(author.getId());
        book.setTitle("The Hobbit");
        book.setPrice(BigDecimal.valueOf(59.99));
        book.setIsbn("9780547928227");
        book.setPublishDate(LocalDate.now());
        book = bookRepo.save(book);
    }

    @Test
    public void shouldCreateBook(){

        Book book1 = new Book();
        book1.setPublisherId(publisher.getId());
        book1.setAuthorId(author.getId());
        book1.setTitle("The Hobbit");
        book1.setPrice(BigDecimal.valueOf(59.99));
        book1.setIsbn("9780547928227");
        book1.setPublishDate(LocalDate.now());
        bookRepo.save(book1);

        assertTrue(bookRepo.existsById(book1.getId()));
    }

    @Test
    public void shouldReadBookById(){
        Optional<Book> foundBooks = bookRepo.findById(book.getId());
        assertEquals(foundBooks.get(), book);
    }

    @Test
    public void shouldReadAll(){
        Book book2 = new Book();
        book2.setPublisherId(publisher.getId());
        book2.setAuthorId(author.getId());
        book2.setTitle("Minecraft");
        book2.setPrice(new BigDecimal(89.99));
        book2.setIsbn("9780547928288");
        book2.setPublishDate(LocalDate.now());
        book2 = bookRepo.save(book2);

        List<Book> bookList = bookRepo.findAll();
        assertEquals(bookList.size(), 2);
    }

    @Test
    public void shouldUpdateBook(){
        book.setTitle("Valorant");
        book = bookRepo.save(book);
        Optional<Book> foundBooks = bookRepo.findById(book.getId());

        assertEquals(foundBooks.get(), book);
    }

    @Test
    public void shouldDeleteByBookId(){
        int test = book.getId();
        bookRepo.deleteById(test);
        Optional<Book> foundBook = bookRepo.findById(test);
        assertFalse(foundBook.isPresent());
    }

    @Test
    public void shouldGetBookByAuthorId() {
        List<Book> bookList = bookRepo.findByAuthorId(author.getId());

        assertEquals(bookList.size(),1);
    }
}