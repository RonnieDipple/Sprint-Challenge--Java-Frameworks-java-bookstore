package com.lambdaschool.oauth2.repository;

import com.lambdaschool.oauth2.models.Author;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

public interface AuthorRepository extends CrudRepository<Author, Long> {

    //Trans actional needed or won't work
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO wrote (bookid, authorid) VALUES (:bookid, :authorid)", nativeQuery = true)
    void createAuthorBooks(long bookid, long authorid);
}
