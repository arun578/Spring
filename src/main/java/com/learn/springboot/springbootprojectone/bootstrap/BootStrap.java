package com.learn.springboot.springbootprojectone.bootstrap;

import com.learn.springboot.springbootprojectone.domain.*;
import com.learn.springboot.springbootprojectone.repositories.*;
import org.springframework.boot.*;
import org.springframework.stereotype.*;

@Component   //It tells the Spring Framework to go ahead and detect this as a spring managed component
public class BootStrap implements CommandLineRunner {
    //In this class we are going to setup initialization of some data for our application to work with.

    /*the CommandLineRunner interface is used to execute code after the Spring application context has
     been initialized and the Spring Boot application has started. It contains a single method run(String... args)
     that takes command-line arguments as input. This interface is often used to perform tasks like initializing resources,
     setting up test data, or running tasks after the Spring context has been set up. */

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;


    public BootStrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Publisher publisher = new Publisher();
        publisher.setName("SFG Publishing");
        publisher.setCity("St. PetersBurg");
        publisher.setState("FL");

        publisherRepository.save(publisher);
        System.out.println("Publisher Count: " + publisherRepository.count());

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain driven design", "123123");

        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        ddd.setPublisher(publisher);
        publisher.getBooks().add(ddd);

        authorRepository.save(eric);
        bookRepository.save(ddd);
        //publisherRepository.save(publisher);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "789657");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        noEJB.setPublisher(publisher);
        publisher.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
        //publisherRepository.save(publisher);


        System.out.println("started in bootstrap");
        System.out.println("Numbers of Books: "+bookRepository.count());
        System.out.println("Publisher Number of Books: "+publisher.getBooks().size());
    }
}
