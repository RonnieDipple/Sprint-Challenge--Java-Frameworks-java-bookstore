package com.lambdaschool.oauth2.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.lambdaschool.oauth2.logging.Loggable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Loggable
@Entity
@Table(name = "sections")
public class Section {

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
    private List<Book> menus = new ArrayList<>();

    public Section(){}

    public Section(String sectionname, List<Book> menus) {
        this.sectionname = sectionname;
        this.menus = menus;
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

    public List<Book> getMenus() {
        return menus;
    }

    public void setMenus(List<Book> menus) {
        this.menus = menus;
    }
}
