package com.example.authorbookrest.mapper;

import com.example.authorbookrest.dto.BookDto;
import com.example.authorbookrest.dto.SaveBookRequest;
import com.example.authorbookrest.entity.Book;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring")
public interface BookMapper {

    BookDto toDto(Book book);

    List<BookDto> toDtoList(List<Book> books);

    Book toEntity(SaveBookRequest saveBookRequest);
}