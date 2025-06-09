package com.example.authorbookrest.mapper;

import com.example.authorbookrest.dto.AuthorDto;
import com.example.authorbookrest.dto.SaveAuthorRequest;
import com.example.authorbookrest.entity.Author;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring")
public interface AuthorMapper {

    AuthorDto toDto(Author author);

    List<AuthorDto> toDtoList(List<Author> authors);

    Author toEntity(SaveAuthorRequest authorRequest);
}