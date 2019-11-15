package com.lambdaschool.oauth2.services;


import com.lambdaschool.oauth2.models.Author;
import com.lambdaschool.oauth2.models.Book;

import java.util.List;

public interface BookService {
    List<Book> findAll();
    Book update(Book book, long id);
    void delete(long id);
    Author save(long bookid, long authorid);
    Book findBookById(long bookid);

}