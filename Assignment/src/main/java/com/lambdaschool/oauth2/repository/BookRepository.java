package com.lambdaschool.oauth2.repository;

import com.lambdaschool.oauth2.models.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository  extends CrudRepository<Book, Long> {
}
