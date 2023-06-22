package com.jhokomari.bookapp.service;

import com.jhokomari.bookapp.dto.BookReqDto;
import org.springframework.http.ResponseEntity;

public interface BookService {
    ResponseEntity<String> createBook(BookReqDto bookReqDto);
}
