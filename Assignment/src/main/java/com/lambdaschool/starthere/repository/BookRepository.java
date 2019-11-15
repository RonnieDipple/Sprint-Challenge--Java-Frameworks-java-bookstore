package com.lambdaschool.starthere.repository;

import com.lambdaschool.starthere.models.AuthorModel;
import com.lambdaschool.starthere.models.BookModel;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository  extends CrudRepository<BookModel, Long> {
}
