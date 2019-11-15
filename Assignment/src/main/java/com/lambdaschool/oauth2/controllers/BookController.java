package com.lambdaschool.oauth2.controllers;

import com.lambdaschool.oauth2.handlers.RestExceptionHandler;
import com.lambdaschool.oauth2.logging.Loggable;
import com.lambdaschool.oauth2.models.Book;
import com.lambdaschool.oauth2.services.AuthorService;
import com.lambdaschool.oauth2.services.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Loggable
@Controller
public class BookController {
    private static final Logger logger = LoggerFactory.getLogger(RestExceptionHandler.class);
    @Autowired
    private BookService booksService;
    @Autowired
    private AuthorService authorService;
    //GET /books/books - returns a JSON object list of all the books, thier sections, and their authors.
    // http://localhost:2019/books/books

    @GetMapping(value = "/books",
            produces = {"application/json"})
    public ResponseEntity<?> listBooks(HttpServletRequest request)
    {
        logger.trace(request.getMethod()
                .toUpperCase() + " " + request.getRequestURI() + " accessed");

        List<Book> allBooks = booksService.findAll();
        return new ResponseEntity<>(allBooks,
                HttpStatus.OK);
    }


        @PutMapping(value = "books/{bookid}", consumes = {"application/json"})
        public ResponseEntity<?> updateBook( @RequestBody
                                                     Book updatedBook,
                                             @PathVariable
                                                     long bookid)
        {

            booksService.update(updatedBook, bookid);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    @PostMapping(value = "/books/{bookid}/authors/{authorid}",
               produces = {"application/json"})
    public ResponseEntity<?> bookToAuthor(@PathVariable long bookid,
                                                @PathVariable long authorid) {

        authorService.createAuthorBooks(bookid, authorid);
        return new ResponseEntity<>(HttpStatus.OK);
    }

        @DeleteMapping(value = "/books/{bookid}")
    public ResponseEntity<?> deleteBook(@PathVariable long bookid){
        booksService.delete(bookid);
        logger.trace("book delete"+ bookid);
        return new ResponseEntity<>(HttpStatus.OK);
    }





    /*  @PostMapping(value = "books/{bookid}/authors/{authorid}", consumes = {"application/json"})
        public ResponseEntity<?> addNewBookWrote(@PathVariable long bookid, @PathVariable long authorid)
        {
            logger.trace("book id:"+ bookid+ "authorid" + authorid + " accessed");
            Authors newAuthors = booksService.save(bookid, authorid);


            return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
        }
*/




}
