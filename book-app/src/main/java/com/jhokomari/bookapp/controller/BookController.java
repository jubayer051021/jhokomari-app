package com.jhokomari.bookapp.controller;

import com.jhokomari.bookapp.dto.BookReqDto;
import com.jhokomari.bookapp.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;
    @PostMapping("/create")
    public ResponseEntity<String> createBook(@RequestBody BookReqDto bookReqDto){
        return bookService.createBook(bookReqDto);
    }
}
