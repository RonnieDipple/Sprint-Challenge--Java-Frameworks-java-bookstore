package com.lambdaschool.oauth2.services;
import com.lambdaschool.oauth2.exceptions.ResourceNotFoundException;
import com.lambdaschool.oauth2.logging.Loggable;
import com.lambdaschool.oauth2.models.Author;
import com.lambdaschool.oauth2.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Loggable
@Service(value = "authorService")
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    private BookService bookService;
    @Autowired
    UserAuditing userAuditing;

    @Autowired
    private AuthorRepository authorrepos;

    @Override
    public Author findAuthorById(long authorid) {
        return authorrepos.findById(authorid).orElseThrow(() ->
                new ResourceNotFoundException(authorid + " not found"));
    }
    @Override
    public void createAuthorBooks(long bookid, long authorid) {

        bookService.findBookById(bookid);
        findAuthorById(authorid);

        authorrepos.createAuthorBooks(bookid, authorid);
    }
    @Override
    public List<Author> findAll() {

        List<Author> list = new ArrayList<>();
        authorrepos.findAll().iterator().forEachRemaining(list::add);
        return list;
    }
}