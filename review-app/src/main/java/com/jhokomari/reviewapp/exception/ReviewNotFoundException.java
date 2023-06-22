package com.jhokomari.reviewapp.exception;

public class ReviewNotFoundException extends RuntimeException{
    public ReviewNotFoundException(String msg){
        super(msg);
    }
}
