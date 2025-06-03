package com.example.authorbookrest.service.impl;

import com.example.authorbookrest.dto.AuthorDto;
import com.example.authorbookrest.dto.SaveAuthorRequest;
import com.example.authorbookrest.entity.Author;
import com.example.authorbookrest.repository.AuthorRepository;
import com.example.authorbookrest.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Override
    public List<AuthorDto> findAll() {
        List<Author> authors = authorRepository.findAll();
        List<AuthorDto> result = new ArrayList<>();
        for (Author author : authors) {
            result.add(new AuthorDto().builder()
                    .id(author.getId())
                    .name(author.getName())
                    .surname(author.getSurname())
                    .phone(author.getPhone())
                    .gender(author.getGender())
                    .build());

        }
        return result;
    }

    @Override
    public AuthorDto save(SaveAuthorRequest authorRequest) {
        Author author = authorRepository.save(Author.builder()
                .name(authorRequest.getName())
                .surname(authorRequest.getSurname())
                .phone(authorRequest.getPhone())
                .dateOfBirthday(authorRequest.getDateOfBirthday())
                .gender(authorRequest.getGender())
                .build());

        return AuthorDto.builder()
                .id(author.getId())
                .name(author.getName())
                .surname(author.getSurname())
                .phone(author.getPhone())
                .gender(author.getGender())
                .build();
    }

    @Override
    public void deleteById(int id) {
        authorRepository.deleteById(id);
    }

    @Override
    public AuthorDto findById(int id) {
        Author author = authorRepository.findById(id).orElse(null);
        if (author == null) {
            return null;
        }
        return AuthorDto.builder()
                .id(author.getId())
                .name(author.getName())
                .surname(author.getSurname())
                .phone(author.getPhone())
                .gender(author.getGender())
                .build();
    }

    @Override
    public AuthorDto update(SaveAuthorRequest authorRequest) {
        Author author = authorRepository.save(Author.builder()
                .name(authorRequest.getName())
                .surname(authorRequest.getSurname())
                .phone(authorRequest.getPhone())
                .dateOfBirthday(authorRequest.getDateOfBirthday())
                .gender(authorRequest.getGender())
                .build());

        return AuthorDto.builder()
                .id(author.getId())
                .name(author.getName())
                .surname(author.getSurname())
                .phone(author.getPhone())
                .gender(author.getGender())
                .build();
    }

    @Override
    public Optional<Author> findByPhone(String phone) {
        return authorRepository.findByPhone(phone);
    }
}
