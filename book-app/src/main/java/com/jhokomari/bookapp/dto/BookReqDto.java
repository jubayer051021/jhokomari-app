package com.jhokomari.bookapp.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookReqDto {
    private String bookName;
    private String authorName;
    private String category;
    private String img;
    private Integer quantity;
    private Double price;
}
