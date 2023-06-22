package com.Rokomari.inventoryservice.exception;

public class InventoryAlreadyExistException extends RuntimeException{
    public InventoryAlreadyExistException(String msg){
        super(msg);
    }
}
