package com.lambdaschool.starthere.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.lambdaschool.starthere.logging.Loggable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Loggable
@Entity
@Table(name = "sections")
public class SectionModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long sectionid;

    @Column(nullable = false,
            unique = true)
    private String sectionname;

    @OneToMany(mappedBy = "section",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @JsonIgnoreProperties("section")
    private List<BookModel> sectionBooks = new ArrayList<>();

    public SectionModel(){}

    public SectionModel(String sectionname, List<BookModel> sectionBooks) {
        this.sectionname = sectionname;
        this.sectionBooks = sectionBooks;
    }

    public long getSectionid() {
        return sectionid;
    }

    public void setSectionid(long sectionid) {
        this.sectionid = sectionid;
    }

    public String getSectionname() {
        return sectionname;
    }

    public void setSectionname(String sectionname) {
        this.sectionname = sectionname;
    }

    public List<BookModel> getSectionBooks() {
        return sectionBooks;
    }

    public void setSectionBooks(List<BookModel> sectionBooks) {
        this.sectionBooks = sectionBooks;
    }
}
