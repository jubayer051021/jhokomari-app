package com.Rokomari.inventoryservice.exception;

public class InventoryNotFoundException extends RuntimeException{
    public InventoryNotFoundException(String msg){
        super(msg);
    }
}
