package com.example.authorbookrest.dto;


import com.example.authorbookrest.entity.Author;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SaveBookRequest {

    private String title;
    private double price;
    private int qty;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdAt;
    private Author author;
}
