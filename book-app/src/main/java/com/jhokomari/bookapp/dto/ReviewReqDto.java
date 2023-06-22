package com.jhokomari.bookapp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReviewReqDto {
    private Integer rating;
    private Long bookId;
    private String userName;
    private String description;
    private String date;
}
