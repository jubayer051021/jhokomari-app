package com.jhokomari.bookapp.client;

import com.jhokomari.bookapp.dto.ReviewReqDto;
import com.jhokomari.bookapp.dto.ReviewResDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.annotation.*;

import java.util.List;

@HttpExchange
public interface ReviewClient {
    @GetExchange("/review")
    public ResponseEntity<List<ReviewResDto>> getAllReview();

    @PostExchange("/review/{userName}/{bookId}")
    public ResponseEntity<String> createReview(@PathVariable("userName") String name, @PathVariable("bookId") Long bookId, @RequestBody ReviewReqDto reviewReqDto);
    @PutExchange("/review/{userName}/{bookId}")
    public ResponseEntity<String> updateReview(@PathVariable("userName") String name,@PathVariable("bookId") Long bookId,@RequestBody ReviewReqDto reviewReqDto);

    @GetExchange("/review/{bookId}")
    public ResponseEntity<List<ReviewResDto>> reviewByBookId(@PathVariable("bookId") Long bookId);

    @GetExchange("/review/ratings/{bookId}")
    public ResponseEntity<Double> ratingsByBookId(@PathVariable("bookId") Long bookId);
    @GetExchange("/review/ratingList/{bookId}")
    public ResponseEntity<List<Integer>> ratingDetailsByBookId(@PathVariable("bookId") Long bookId);

    @DeleteExchange("/review/{bookId}")
    public ResponseEntity<String> deleteAllBookId(@PathVariable("bookId") Long bookId);
}
