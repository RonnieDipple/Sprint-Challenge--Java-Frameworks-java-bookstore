package com.lambdaschool.starthere.repository;

import com.lambdaschool.starthere.models.AuthorModel;
import com.lambdaschool.starthere.models.Role;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<AuthorModel, Long> {
}
