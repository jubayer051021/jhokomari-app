package com.jhokomari.reviewapp.mapper;

import com.jhokomari.reviewapp.dto.ReviewReqDto;
import com.jhokomari.reviewapp.dto.ReviewResDto;
import com.jhokomari.reviewapp.entity.ReviewEntity;

public class ReviewMapper {
    public static ReviewEntity reviewDtoToEntity(ReviewReqDto reviewReqDto) {
        return ReviewEntity.builder()
                .bookId(reviewReqDto.getBookId())
                .userName(reviewReqDto.getUserName())
                .rating(reviewReqDto.getRating())
                .description(reviewReqDto.getDescription())
                .date(reviewReqDto.getDate())
                .build();
    }
    public static ReviewResDto reviewEntityToDto(ReviewEntity reviewEntity) {
        return ReviewResDto.builder()
                .reviewId(reviewEntity.getReviewId())
                .bookId(reviewEntity.getBookId())
                .userName(reviewEntity.getUserName())
                .rating(reviewEntity.getRating())
                .description(reviewEntity.getDescription())
                .date(reviewEntity.getDate())
                .build();
    }
}
