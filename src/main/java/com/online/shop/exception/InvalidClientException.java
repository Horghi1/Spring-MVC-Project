package com.online.shop.exception;

public class InvalidClientException extends Exception {
    
    private final String message;
    
    public InvalidClientException(String message) {
        super(message);
        
        this.message = message;
    }
    
    @Override
    public String getMessage() {
        return this.message;
    }
    
}
