package com.example.controller;

import com.example.entity.Book;
import com.example.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class TestController {

    @Autowired
    private BookService bookService;

    @GetMapping("/getBook")
    public Book getBook(String title){
        log.info("book title is {}",title);
        return bookService.getBookByTitle(title);
    }

    @PostMapping("/getBook")
    public Book postBook(@RequestBody Book book){
        log.info("book info : {}",book);
        return book;
    }
}
