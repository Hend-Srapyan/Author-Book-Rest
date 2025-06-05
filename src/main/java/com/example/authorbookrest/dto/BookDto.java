package com.example.authorbookrest.dto;

import com.example.authorbookrest.entity.Author;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookDto {

    private int id;
    private String title;
    private double price;
    private int qty;
    private Author author;
}
