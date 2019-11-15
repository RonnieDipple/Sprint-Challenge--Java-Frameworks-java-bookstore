package com.lambdaschool.oauth2.services;


import com.lambdaschool.oauth2.exceptions.ResourceNotFoundException;
import com.lambdaschool.oauth2.logging.Loggable;
import com.lambdaschool.oauth2.models.Author;
import com.lambdaschool.oauth2.models.Book;
import com.lambdaschool.oauth2.repository.AuthorRepository;
import com.lambdaschool.oauth2.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;


@Loggable
@Service(value = "bookService")
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;
    @Autowired
    AuthorRepository authorRepo;

    /*@Autowired
    WroteRepo wroteRepo;*/

    @Autowired
    AuthorService authorService;
    @Override
    public Book findBookById(long bookid) {
        return bookRepository.findById(bookid).orElseThrow(() ->
                new ResourceNotFoundException("Book id " + bookid + " not found!"));
    }

    @Override
    public List<Book> findAll() {
        List<Book> list = new ArrayList<>();
        bookRepository.findAll()
                .iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public Book update(Book books, long id) {
        Book currentBook = bookRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(Long.toString(id)));

        if (books.getBooktitle() != null)
        {
            currentBook.setBooktitle(books.getBooktitle());
        }

        if (books.getISBN() != null)
        {
            currentBook.setISBN(books.getISBN());
        }

        if (books.getCopy() != 0)
        {
            currentBook.setCopy(books.getCopy());
        }


        return bookRepository.save(currentBook);
    }
    @Transactional
    @Override
    public Author save(long bookid, long authorid) {

        if(bookRepository.findById(bookid).isEmpty()){
            throw new ResourceNotFoundException("not found/Book ID:" + bookid);
        }
        if(authorRepo.findById(authorid).isEmpty()){
            throw new ResourceNotFoundException("not found/Author ID:" + authorid );
        }

        Author author = authorRepo.findById(authorid).get();
        Book book = bookRepository.findById(bookid).get();

        author.addAuthorBooks(book);

       // Wrote newBookAuthor = new Wrote(author,book);

        return authorRepo.save(author);
    }
    @Override
    public void delete(long id) {
        if (bookRepository.findById(id).isPresent())
        {
            bookRepository.deleteById(id);
        }
        else
        {
            throw new ResourceNotFoundException("not found/ID: " + id );
        }
    }


   /* @Override
    public Book update(Long id, String bookTitle, String copyright, String ISBN) {
        return null;
    }*/
}

