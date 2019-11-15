package com.lambdaschool.oauth2.services;
import com.lambdaschool.oauth2.models.Author;


import java.util.List;


public interface AuthorService {
    Author findAuthorById(long authorid);

    List<Author> findAll();

    void createAuthorBooks(long bookid, long authorid);
}

