package com.jhokomari.reviewapp.exception;

public class ReviewAlreadyExistException extends RuntimeException{
    public ReviewAlreadyExistException(String msg){
        super(msg);
    }
}
