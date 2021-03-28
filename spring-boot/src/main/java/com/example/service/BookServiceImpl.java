package com.example.service;

import com.example.entity.Book;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
    @Override
    public Book getBookByTitle(String title) {
        return Book.builder().title("lean java").price(23).build();
    }
}
