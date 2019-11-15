package com.lambdaschool.starthere.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.lambdaschool.starthere.logging.Loggable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Loggable
@Entity
@Table(name = "authors")
public class AuthorModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long authorid;

    private String lastname;
    private String firstname;

    @ManyToMany(mappedBy = "authors",
            cascade = CascadeType.ALL)
    private List<BookModel> authorBooks = new ArrayList<>();

    public AuthorModel(){}

    public AuthorModel(String lastname, String firstname, List<BookModel> authorBooks) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.authorBooks = authorBooks;
    }

    public long getAuthorid() {
        return authorid;
    }

    public void setAuthorid(long authorid) {
        this.authorid = authorid;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public List<BookModel> getAuthorBooks() {
        return authorBooks;
    }

    public void setAuthorBooks(List<BookModel> authorBooks) {
        this.authorBooks = authorBooks;
    }
}
