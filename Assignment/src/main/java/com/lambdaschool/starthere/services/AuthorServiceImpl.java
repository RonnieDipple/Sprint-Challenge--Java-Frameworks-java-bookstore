package com.lambdaschool.starthere.services;


import com.lambdaschool.starthere.logging.Loggable;
import com.lambdaschool.starthere.models.AuthorModel;
import com.lambdaschool.starthere.models.Role;
import com.lambdaschool.starthere.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;
@Loggable
@Service(value = "authorService")
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    AuthorRepository authorRepository;


    @Override
    public List<AuthorModel> findAll()
    {
        List<AuthorModel> list = new ArrayList<>();
        authorRepository.findAll()
                .iterator().forEachRemaining(list::add);
        return list;
    }
}
