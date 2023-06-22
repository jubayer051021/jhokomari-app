package com.jhokomari.bookapp.service.Imp;

import com.jhokomari.bookapp.client.InventoryClient;
import com.jhokomari.bookapp.client.ReviewClient;
import com.jhokomari.bookapp.dto.BookReqDto;
import com.jhokomari.bookapp.entity.BookEntity;
import com.jhokomari.bookapp.exception.BookAlreadyExistException;
import com.jhokomari.bookapp.exception.BookNotFoundException;
import com.jhokomari.bookapp.mapper.BookMapping;
import com.jhokomari.bookapp.repository.BookRepository;
import com.jhokomari.bookapp.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BookServiceImp implements BookService {
    private final BookRepository bookRepository;
    private final InventoryClient inventoryClient;
    private final ReviewClient reviewClient;
    @Override
    @Transactional
    public ResponseEntity<String> createBook(BookReqDto bookReqDto) {
        BookEntity existBook=bookRepository.findByBookNameAndAuthorName(bookReqDto.getBookName(),bookReqDto.getAuthorName());
        if(existBook!=null){
            throw new BookAlreadyExistException("Book Already exist in The Database");
        }
        BookEntity book=bookRepository.save(BookMapping.bookReqDtoToEntity(bookReqDto));
        Long inventoryId=book.getBookId();
        ResponseEntity<String> saveInventory=inventoryClient.createInventory(BookMapping.bookReqDtoToInventoryReqDto(inventoryId,bookReqDto));
        if(saveInventory.getStatusCode()!= HttpStatus.CREATED){
            throw new BookNotFoundException("Book service can not be created");
        }
        return new ResponseEntity<>("SuccessFully created",HttpStatus.CREATED);
    }
}
