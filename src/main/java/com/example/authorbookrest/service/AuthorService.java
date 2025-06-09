package com.example.authorbookrest.service;

import com.example.authorbookrest.dto.AuthorDto;
import com.example.authorbookrest.dto.SaveAuthorRequest;
import com.example.authorbookrest.entity.Author;
import java.util.List;
import java.util.Optional;

public interface AuthorService {

    List<AuthorDto> findAll();

    AuthorDto save(SaveAuthorRequest authorRequest);

    void deleteById(int id);

    AuthorDto findById(int id);

    AuthorDto update(SaveAuthorRequest authorRequest);

    Optional<Author> findByPhone(String phone);
}