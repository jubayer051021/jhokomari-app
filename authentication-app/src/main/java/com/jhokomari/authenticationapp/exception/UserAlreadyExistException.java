package com.jhokomari.authenticationapp.exception;

public class UserAlreadyExistException extends RuntimeException{
    public UserAlreadyExistException(String msg){
        super(msg);
    }
}
