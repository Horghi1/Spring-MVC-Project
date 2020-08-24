package com.online.shop.utils;

import com.online.shop.domain.Client;
import com.online.shop.domain.Product;
import com.online.shop.exception.InvalidClientException;
import com.online.shop.exception.InvalidProductException;
import java.math.BigDecimal;

public class Validator {
    public static void validateProduct(Product product) throws InvalidProductException {
        if(product.getName() == null || product.getName().length() == 0) {
            throw new InvalidProductException("Invalid product name");
        }
        
        if(product.getUnitPrice() == null || product.getUnitPrice().compareTo(BigDecimal.ZERO) <= 0) {
            throw new InvalidProductException("Invalid product price");
        }
        
        if(product.getUnitsInStock() <= 0) {
            throw new InvalidProductException("Invalid product stock");
        }
        
        if(product.getManufacturer() == null || product.getManufacturer().length() == 0) {
            throw new InvalidProductException("Invalid product manufacturer");
        }
        
        if(product.getCategory() == null || product.getCategory().length() == 0) {
            throw new InvalidProductException("Invalid product category");
        }
        
        if(product.getCondition() == null || product.getCondition() == null) {
            throw new InvalidProductException("Invalid product condition");
        }
    }
    
    public static void validateClient(Client client) throws InvalidClientException {
        if(client.getFirstName() == null || client.getFirstName().length() == 0) {
             throw new InvalidClientException("Invalid client first name");
        }
        
        if(client.getLastName() == null || client.getLastName().length() == 0) {
             throw new InvalidClientException("Invalid client last name");
        }
        
         if(client.getEmail() == null || !isValidEmail(client.getEmail())) {
             throw new InvalidClientException("Invalid client email");
        }
    }

    private static boolean isValidEmail(String email) {
        for(int i = 0; i<email.length(); i++){
            if((email.charAt(i) >= 'a' && email.charAt(i) <= 'z') || (email.charAt(i) >= '0' && email.charAt(i) <= '9') ||
                    email.charAt(i) == '_' || email.charAt(i) == '.' || email.charAt(i) == '@') {
                //do nothing
            } else {
                return false;
            }
        }

        if(!email.contains("@")) {
                return false;
        }

        if(!email.contains(".")) {
                return false;
        }
        
        return true;
    }
}
