package com.lambdaschool.starthere.services;


import com.lambdaschool.starthere.logging.Loggable;
import com.lambdaschool.starthere.models.Author;
import com.lambdaschool.starthere.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Loggable
@Service(value = "authorService")
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    AuthorRepository authorRepository;


    @Override
    public List<Author> findAll()
    {
        List<Author> list = new ArrayList<>();
        authorRepository.findAll()
                .iterator().forEachRemaining(list::add);
        return list;
    }
}
