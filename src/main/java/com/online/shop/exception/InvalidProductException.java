package com.online.shop.exception;

public class InvalidProductException extends Exception {
    
    private final String message;
    
    public InvalidProductException(String message) {
        super(message);
        
        this.message = message;
    }
    
    @Override
    public String getMessage() {
        return this.message;
    }
    
}
