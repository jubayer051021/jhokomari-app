package com.jhokomari.bookapp.mapper;

import com.jhokomari.bookapp.dto.BookReqDto;
import com.jhokomari.bookapp.dto.InventoryReqDto;
import com.jhokomari.bookapp.entity.BookEntity;

public class BookMapping {
    public static BookEntity bookReqDtoToEntity(BookReqDto bookReqDto){
        return BookEntity.builder()
                .bookName(bookReqDto.getBookName())
                .authorName(bookReqDto.getAuthorName())
                .category(bookReqDto.getCategory())
                .img(bookReqDto.getImg())
                .build();
    }
    public static InventoryReqDto bookReqDtoToInventoryReqDto(Long id,BookReqDto bookReqDto){
        return InventoryReqDto.builder()
                .inventoryId(id)
                .quantity(bookReqDto.getQuantity())
                .price(bookReqDto.getPrice())
                .build();
    }
}
