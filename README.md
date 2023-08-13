# Summative-2


## User Stories

Your service must implement the following user stories:

-   As an API user, I would like to create, read, update, and delete authors.
-   As an API user, I would like to create, read, update, and delete publishers.
-   As an API user, I would like to create, read, update, and delete books.
-   As an API user, I would like to find all books by a given author.

## Requirements

### General Setup and Format

-   Your project must be created in an IntelliJ project called  `Summative-2-Lastname-Firstname`.
    
-   Initialize the project using  `start.spring.io`  using project options as demonstrated previously in class:
    
    -   Project:  `Maven`
        
    -   Language:  `Java`
        
    -   Spring Boot: Pick the latest version of 2.x.x.
        
    -   Project Metadata:
        
    -   Group:  `com.company`
        
    -   Artifact:  `bookstore`
        
        **NOTE**
        
        Setting the Artifact value will automatically update the values for Name and Package Name.
        
    -   Packaging:  `Jar`
        
    -   Java:  `11`
        
    -   Dependencies: Spring Web, Spring Data JPA, and Spring for GraphQL.
        
-   Your project must have a series of tests using MockMvc.
    
-   Your project must use the existing  `book_store`  database.
    
-   Your REST API must accept and return data in JSON format where appropriate.
    
-   Your REST API must be documented using Swagger.
    
    -   Save the  `.yaml`  file in the root of the project directory.

## Bookstore REST API

Your project must be based on the existing  `book_store`  database. The script to create the  `book_store`  database is provided.

The Bookstore web service manages inventory for a bookstore. You must implement and document REST APIs to allow callers to create, read, read all, update, and delete Books, Authors, and Publishers in the system. The system must also allow callers to find Books by Author.

## Bookstore GraphQL

Your project must support GraphQL queries to retrieve the following information:

-   Get a publisher by id.
    -   Including books for the publisher and authors for the books.
-   Get an author by id.
    -   Including books by the author.
-   Get a book by id.
    -   Including the author and publisher of the book.

## Video Summary

Create a 1 to 3 minute video summary of your project that meets the following requirements:

-   Video should be created in MP4 format.
    
-   Video should include screen-capture recordings to highlight the sections of the project that are important in meeting the project requirements.
    

----------

## Grading Requirements

For this project, your grade will consist of a combination of general setup and format requirements and your actual code. Refer to the following criteria for more detailed information.

### **General set up and format requirements: 10%**

-   Solution must be in an IntelliJ project called  `Summative-2-Lastname-Firstname`.
-   Project must be built using Spring Web, Spring Data JPA, and Spring for GraphQL. Initialize the project using  `start.spring.io`  using project options as demonstrated previously in class.
-   Project must use Spring Data JPA that follows the pattern shown in class.
-   The REST API must accept and return data in JSON format where appropriate.
-   The REST API must be documented with Swagger. Save the .yaml file in the root of your project directory.
-   Provide a 1-3 minute Video Summary of the project.

### **Book API: 25%**

-   Code is clean (follows general patterns as presented in class).
-   Implementation of Book model
-   Implementation of Book repository and controller for:
    -   Create
    -   Read by Id
    -   Read All
    -   Update
    -   Delete
    -   Search Book by Author Id
-   Test of Book repository and MockMvc test cases for:
    -   Create
    -   Read by Id
    -   Read All
    -   Update
    -   Delete
    -   Search Book by Author Id## User Stories

Your service must implement the following user stories:

-   As an API user, I would like to create, read, update, and delete authors.
-   As an API user, I would like to create, read, update, and delete publishers.
-   As an API user, I would like to create, read, update, and delete books.
-   As an API user, I would like to find all books by a given author.

## Requirements

### General Setup and Format

-   Your project must be created in an IntelliJ project called  `Summative-2-Lastname-Firstname`.
    
-   Initialize the project using  `start.spring.io`  using project options as demonstrated previously in class:
    
    -   Project:  `Maven`
        
    -   Language:  `Java`
        
    -   Spring Boot: Pick the latest version of 2.x.x.
        
    -   Project Metadata:
        
    -   Group:  `com.company`
        
    -   Artifact:  `bookstore`
        
        **NOTE**
        
        Setting the Artifact value will automatically update the values for Name and Package Name.
        
    -   Packaging:  `Jar`
        
    -   Java:  `11`
        
    -   Dependencies: Spring Web, Spring Data JPA, and Spring for GraphQL.
        
-   Your project must have a series of tests using MockMvc.
    
-   Your project must use the existing  `book_store`  database.
    
-   Your REST API must accept and return data in JSON format where appropriate.
    
-   Your REST API must be documented using Swagger.
    
    -   Save the  `.yaml`  file in the root of the project directory.

## Bookstore REST API

Your project must be based on the existing  `book_store`  database. The script to create the  `book_store`  database is provided.

The Bookstore web service manages inventory for a bookstore. You must implement and document REST APIs to allow callers to create, read, read all, update, and delete Books, Authors, and Publishers in the system. The system must also allow callers to find Books by Author.

## Bookstore GraphQL

Your project must support GraphQL queries to retrieve the following information:

-   Get a publisher by id.
    -   Including books for the publisher and authors for the books.
-   Get an author by id.
    -   Including books by the author.
-   Get a book by id.
    -   Including the author and publisher of the book.

## Video Summary

