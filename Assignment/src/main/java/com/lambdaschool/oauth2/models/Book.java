package com.lambdaschool.oauth2.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.lambdaschool.oauth2.logging.Loggable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Loggable
@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long bookid;

    @Column(nullable = false)
    private String booktitle;

    @Column(nullable = false,
            unique = true)
    private String ISBN;

    private int copy;

    @ManyToMany
    @JoinTable(name = "bookauthor",
            joinColumns = @JoinColumn(name = "bookid"),
            inverseJoinColumns = @JoinColumn(name = "authorid")
    )
    @JsonIgnoreProperties("books")
    List<Author> authors = new ArrayList<>();


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sectionid",
            nullable = false)
    @JsonIgnoreProperties({"books"})
    private Section section;

    public Book(){}

    public Book(String booktitle, String ISBN, int copy, List<Author> authors, Section section) {
        this.booktitle = booktitle;
        this.ISBN = ISBN;
        this.copy = copy;
        this.authors = authors;
        this.section = section;
    }

    public long getBookid() {
        return bookid;
    }

    public void setBookid(long bookid) {
        this.bookid = bookid;
    }

    public String getBooktitle() {
        return booktitle;
    }

    public void setBooktitle(String booktitle) {
        this.booktitle = booktitle;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public int getCopy() {
        return copy;
    }

    public void setCopy(int copy) {
        this.copy = copy;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }
}
