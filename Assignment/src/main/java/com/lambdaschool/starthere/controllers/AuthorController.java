package com.lambdaschool.starthere.controllers;


import com.lambdaschool.starthere.logging.Loggable;
import com.lambdaschool.starthere.models.AuthorModel;
import com.lambdaschool.starthere.models.Role;
import com.lambdaschool.starthere.services.AuthorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Loggable
@RestController
@RequestMapping("/authors")
public class AuthorController {

    private static final Logger logger = LoggerFactory.getLogger(AuthorController.class);
    @Autowired
    private AuthorService authorService;

//GET /authors/authors - returns a JSON object list of all the authors, their books, and the book's section.

    // http://localhost:2019/authors/authors
    @GetMapping(value = "/authors",
            produces = {"application/json"})
    public ResponseEntity<?> listAuthors(HttpServletRequest request)
    {
        logger.trace(request.getMethod()
                .toUpperCase() + " " + request.getRequestURI() + " accessed");

        List<AuthorModel> allAuthors = authorService.findAll();
        return new ResponseEntity<>(allAuthors,
                HttpStatus.OK);
    }

}
