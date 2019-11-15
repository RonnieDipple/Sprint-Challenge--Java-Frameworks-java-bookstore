package com.lambdaschool.oauth2.controllers;

import com.lambdaschool.oauth2.handlers.RestExceptionHandler;
import com.lambdaschool.oauth2.logging.Loggable;
import com.lambdaschool.oauth2.models.Author;
import com.lambdaschool.oauth2.services.AuthorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Loggable
@Controller
public class AuthorsController {
    private static final Logger logger = LoggerFactory.getLogger(RestExceptionHandler.class);
    @Autowired
    private AuthorService authorService;
    //GET /books/books - returns a JSON object list of all the books, thier sections, and their authors.
    // http://localhost:2019/books/books
    @GetMapping(value = "/authors", produces = {"application/json"})
    public ResponseEntity<?> listAllAuthors(HttpServletRequest request) {

        logger.trace(request.getMethod().toUpperCase() + "_" + request.getRequestURI());
        List<Author> myAuthors = authorService.findAll();
        return new ResponseEntity<>(myAuthors, HttpStatus.OK);
    }
}
