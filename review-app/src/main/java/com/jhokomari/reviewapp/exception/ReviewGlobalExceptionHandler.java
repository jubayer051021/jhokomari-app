package com.jhokomari.reviewapp.exception;

import com.jhokomari.reviewapp.dto.ErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ReviewGlobalExceptionHandler {
    @ExceptionHandler({ReviewAlreadyExistException.class, ReviewNotFoundException.class})
    public ResponseEntity<Object> runtimeException(Exception ex) {
        if(ex instanceof ReviewNotFoundException) {
            ErrorResponseDto error = new ErrorResponseDto(HttpStatus.NOT_FOUND.value(), ex.getMessage());
            return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
        }else if(ex instanceof ReviewAlreadyExistException) {
            ErrorResponseDto error = new ErrorResponseDto(HttpStatus.NOT_ACCEPTABLE.value(), ex.getMessage());
            return new ResponseEntity<>(error, HttpStatus.NOT_ACCEPTABLE);
        }
        else {
            ErrorResponseDto error=new ErrorResponseDto(HttpStatus.INTERNAL_SERVER_ERROR.value(),"unexpected error occurred");
            return new ResponseEntity<>(error,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
