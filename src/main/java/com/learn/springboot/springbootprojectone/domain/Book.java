package com.learn.springboot.springbootprojectone.domain;

import jakarta.persistence.*;

import java.util.*;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String isbn;

    @ManyToOne
    private Publisher publisher;

    @ManyToMany
    @JoinTable(name = "author_book", //Underneath the database we have the table for Author and table for book. We are going to use JoinTable called author_book that is going to hold relationship between records in the author table and records in the book table.
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id"))
    private Set<Author> authors = new HashSet<>();

    /*
    * We added below code in Book Class

        @JoinTable(name="author_book",
                    joinColumns=@JoinColumn(name="book_id"),
                    inverseJoinColumns = @JoinColumn(name="author_id"))
        private Set<Author> authors;

        Can we add same type of code in Author class with change of joinCloumns and inverseJoinColumns?

        @JoinTable(name="author_book",
                    joinColumns=@JoinColumn(name="author_id"),
                    inverseJoinColumns = @JoinColumn(name="book_id"))
        private Set<Author> authors;


        what is different between these two code for many to many relationship?


        The difference is who owns the relationship. In existing code, Book is the owning side of the relationship. If you have a use case of making Author the owning side, you can take the alternate approach you stated.
    * */

    public Book() {
    }

    public Book(String title, String isbn) {
        this.title = title;
        this.isbn = isbn;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                ", authors=" + authors +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

}
