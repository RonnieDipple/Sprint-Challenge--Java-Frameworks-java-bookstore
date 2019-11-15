package com.lambdaschool.starthere.controllers;


import com.lambdaschool.starthere.logging.Loggable;
import com.lambdaschool.starthere.models.AuthorModel;
import com.lambdaschool.starthere.models.BookModel;
import com.lambdaschool.starthere.services.AuthorService;
import com.lambdaschool.starthere.services.BookService;
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
@RequestMapping("/books")
public class BookController {

    private static final Logger logger = LoggerFactory.getLogger(BookController.class);
    @Autowired
    private BookService bookService;

    //GET /books/books - returns a JSON object list of all the books, thier sections, and their authors.
    // http://localhost:2019/books/books
    @GetMapping(value = "/books",
            produces = {"application/json"})
    public ResponseEntity<?> listBooks(HttpServletRequest request)
    {
        logger.trace(request.getMethod()
                .toUpperCase() + " " + request.getRequestURI() + " accessed");

        List<BookModel> allBooks = bookService.findAll();
        return new ResponseEntity<>(allBooks,
                HttpStatus.OK);
    }
}
