package com.example.authorbookrest.service.impl;


import com.example.authorbookrest.dto.BookDto;
import com.example.authorbookrest.dto.SaveBookRequest;
import com.example.authorbookrest.entity.Book;
import com.example.authorbookrest.repository.BookRepository;
import com.example.authorbookrest.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public List<BookDto> findAll() {
        List<Book> books = bookRepository.findAll();
        List<BookDto> result = new ArrayList<>();
        for (Book book : books) {
            result.add(new BookDto().builder()
                    .id(book.getId())
                    .title(book.getTitle())
                    .price(book.getPrice())
                    .author(book.getAuthor())
                    .build());
        }
        return result;
    }


    @Override
    public BookDto save(SaveBookRequest bookRequest) {
        Book book = bookRepository.save(Book.builder()
                .title(bookRequest.getTitle())
                .price(bookRequest.getPrice())
                .qty(bookRequest.getQty())
                .createdAt(bookRequest.getCreatedAt())
                .author(bookRequest.getAuthor())
                .build());

        return BookDto.builder()
                .id(book.getId())
                .title(book.getTitle())
                .price(book.getPrice())
                .author(book.getAuthor())
                .build();
    }

    @Override
    public BookDto findById(int id) {
       Book book = bookRepository.findById(id).orElse(null);
       if (book == null) {
           return null;
       }
        return BookDto.builder()
                .id(book.getId())
                .title(book.getTitle())
                .price(book.getPrice())
                .author(book.getAuthor())
                .build();
    }

    @Override
    public void deleteById(int id) {
        bookRepository.deleteById(id);
    }

    @Override
    public BookDto update(SaveBookRequest bookRequest) {
        Book book = bookRepository.save(Book.builder()
                .title(bookRequest.getTitle())
                .price(bookRequest.getPrice())
                .qty(bookRequest.getQty())
                .createdAt(bookRequest.getCreatedAt())
                .author(bookRequest.getAuthor())
                .build());

        return BookDto.builder()
                .id(book.getId())
                .title(book.getTitle())
                .price(book.getPrice())
                .author(book.getAuthor())
                .build();
    }

}
