package com.jhokomari.reviewapp.controller;

import com.jhokomari.reviewapp.dto.ReviewReqDto;
import com.jhokomari.reviewapp.dto.ReviewResDto;
import com.jhokomari.reviewapp.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/review")
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;
    @GetMapping
    public ResponseEntity<List<ReviewResDto>> getAllReview(){
        return reviewService.getAllReview();
    }
    @PostMapping("/{userName}/{bookId}")
    public ResponseEntity<String> createReview(@PathVariable("userName") String name,@PathVariable("bookId") Long bookId,@RequestBody ReviewReqDto reviewReqDto){
        return reviewService.createReview(name,bookId,reviewReqDto);
    }
    @PutMapping("/{userName}/{bookId}")
    public ResponseEntity<String> updateReview(@PathVariable("userName") String name,@PathVariable("bookId") Long bookId,@RequestBody ReviewReqDto reviewReqDto){
        return reviewService.updateReview(name,bookId,reviewReqDto);
    }
    @GetMapping("/{bookId}")
    public ResponseEntity<List<ReviewResDto>> reviewByBookId(@PathVariable("bookId") Long bookId){
        return reviewService.reviewByBookId(bookId);
    }
    @GetMapping("/ratings/{bookId}")
    public ResponseEntity<Double> ratingsByBookId(@PathVariable("bookId") Long bookId){
        return reviewService.ratingsByBookId(bookId);
    }
    @GetMapping("/ratingList/{bookId}")
    public ResponseEntity<List<Integer>> ratingDetailsByBookId(@PathVariable("bookId") Long bookId){
        return reviewService.ratingDetailsByBookId(bookId);
    }
    @DeleteMapping("/{bookId}")
    public ResponseEntity<String> deleteAllBookId(@PathVariable("bookId") Long bookId){
        return reviewService.deleteAllBookId(bookId);
    }
}
