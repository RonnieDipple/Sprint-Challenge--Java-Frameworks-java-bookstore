package com.lambdaschool.starthere.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.lambdaschool.starthere.logging.Loggable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Loggable
@Entity
@Table(name = "books")
public class BookModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long bookid;

    @Column(nullable = false)
    private String booktitle;

    @Column(nullable = false,
            unique = true)
    private String ISBN;

    private int copy;

    @ManyToMany(mappedBy = "books",
            cascade = CascadeType.ALL)
    @JsonIgnoreProperties("books")
    private List<AuthorModel> authors = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "bookid",
            nullable = false)
    @JsonIgnoreProperties("ISBN")
    private SectionModel sectionModel;

    public BookModel(){}

    public BookModel(String booktitle, String ISBN, int copy, List<AuthorModel> authors, SectionModel sectionModel) {
        this.booktitle = booktitle;
        this.ISBN = ISBN;
        this.copy = copy;
        this.authors = authors;
        this.sectionModel = sectionModel;
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

    public List<AuthorModel> getAuthors() {
        return authors;
    }

    public void setAuthors(List<AuthorModel> authors) {
        this.authors = authors;
    }

    public SectionModel getSectionModel() {
        return sectionModel;
    }

    public void setSectionModel(SectionModel sectionModel) {
        this.sectionModel = sectionModel;
    }
}
