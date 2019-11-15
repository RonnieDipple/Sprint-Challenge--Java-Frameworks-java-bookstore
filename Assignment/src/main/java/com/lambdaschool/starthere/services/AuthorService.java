package com.lambdaschool.starthere.services;


import com.lambdaschool.starthere.logging.Loggable;
import com.lambdaschool.starthere.models.AuthorModel;
import com.lambdaschool.starthere.models.Role;
import org.springframework.stereotype.Service;

import java.util.List;


public interface AuthorService {
    List<AuthorModel> findAll();
}
