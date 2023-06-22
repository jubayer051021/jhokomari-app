package com.jhokomari.reviewapp.service.Imp;

import com.jhokomari.reviewapp.dto.ReviewReqDto;
import com.jhokomari.reviewapp.dto.ReviewResDto;
import com.jhokomari.reviewapp.entity.ReviewEntity;
import com.jhokomari.reviewapp.exception.ReviewAlreadyExistException;
import com.jhokomari.reviewapp.exception.ReviewNotFoundException;
import com.jhokomari.reviewapp.mapper.ReviewMapper;
import com.jhokomari.reviewapp.repository.ReviewRepository;
import com.jhokomari.reviewapp.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ReviewServiceImp implements ReviewService {
    private final ReviewRepository reviewRepository;

    @Override
    public ResponseEntity<String> createReview(String name,Long bookId,ReviewReqDto reviewReqDto) {
        ReviewEntity existingReview = reviewRepository.findByUserNameAndBookId(name,bookId);
        if (existingReview != null) {
            throw new ReviewAlreadyExistException("Review Already exist.. please insert new Review");
        }
        ReviewEntity newReview = ReviewMapper.reviewDtoToEntity(reviewReqDto);
        reviewRepository.save(newReview);
        return new ResponseEntity<>("Successfully Review created", HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<String> updateReview(String name,Long bookId, ReviewReqDto reviewReqDto) {
        ReviewEntity existingReview = reviewRepository.findByUserNameAndBookId(name,bookId);
        if (existingReview == null) {
            throw new ReviewNotFoundException("Review Already exist.. please insert new Review");
        }
        existingReview.setDescription(reviewReqDto.getDescription());
        existingReview.setRating(reviewReqDto.getRating());
        existingReview.setDate(reviewReqDto.getDate());
        reviewRepository.save(existingReview);
        return new ResponseEntity<>("Successfully Review updated", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<ReviewResDto>> reviewByBookId(Long bookId) {
        List<ReviewEntity> reviewList = reviewRepository.findAllByBookId(bookId);
        if (reviewList.isEmpty()) {
            throw new ReviewNotFoundException("This book Review List is Empty");
        }
        List<ReviewResDto> reviewResList = reviewList.stream().map(ReviewMapper::reviewEntityToDto).toList();
        return new ResponseEntity<>(reviewResList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<ReviewResDto>> getAllReview() {
        List<ReviewEntity> reviewEntityList = reviewRepository.findAll();
        List<ReviewResDto> reviewResDtoList = reviewEntityList.stream().map(ReviewMapper::reviewEntityToDto).toList();
        return new ResponseEntity<>(reviewResDtoList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Double> ratingsByBookId(Long bookId) {
        List<ReviewEntity> reviewList = reviewRepository.findAllByBookId(bookId);
        if (reviewList.isEmpty()) {
            return new ResponseEntity<>(0.0, HttpStatus.OK);
        }
        double ratings = 0;
        for (ReviewEntity review : reviewList) {
            ratings = ratings + review.getRating();
        }
        return new ResponseEntity<>(ratings/reviewList.size(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Integer>> ratingDetailsByBookId(Long bookId) {
        List<ReviewEntity> reviewList = reviewRepository.findAllByBookId(bookId);
        Map<Integer, Integer> ratingMap = new HashMap<>();
        int j;
        for (j = 1; j <= 5; j++) {
            ratingMap.put(j, 0);
        }
        for (ReviewEntity review : reviewList) {
            ratingMap.put(review.getRating(), ratingMap.get(review.getRating()) + 1);
        }
        List<Integer> ratingList = new ArrayList<>();
        for (Integer rating : ratingMap.keySet()) {
            ratingList.add(ratingMap.get(rating));
        }
        return new ResponseEntity<>(ratingList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> deleteAllBookId(Long bookId) {
        List<ReviewEntity> reviewList = reviewRepository.findAllByBookId(bookId);
        if(reviewList.isEmpty()){
            throw new ReviewNotFoundException("This book has no review");
        }
        for (ReviewEntity review:reviewList){
            reviewRepository.delete(review);
        }
        return  new ResponseEntity<>("SuccessFully deleted",HttpStatus.OK);
    }
}