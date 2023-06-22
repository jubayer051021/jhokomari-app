package com.jhokomari.reviewapp.service;

import com.jhokomari.reviewapp.dto.ReviewReqDto;
import com.jhokomari.reviewapp.dto.ReviewResDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ReviewService {
    ResponseEntity<String> createReview(String name,Long bookId,ReviewReqDto reviewReqDto);

    ResponseEntity<String> updateReview(String name,Long bookId,ReviewReqDto reviewReqDto);

    ResponseEntity<List<ReviewResDto>> reviewByBookId(Long bookId);

    ResponseEntity<List<ReviewResDto>> getAllReview();

    ResponseEntity<Double> ratingsByBookId(Long bookId);

    ResponseEntity<List<Integer>> ratingDetailsByBookId(Long bookId);

    ResponseEntity<String> deleteAllBookId(Long bookId);
}
