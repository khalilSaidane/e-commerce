package com.khalil.saidane.ecommerce.exeption;

public class EmailAlreadyUsedException extends Exception {
    public EmailAlreadyUsedException(String email) {
        super(String.format(email+"  already used try a unique one"));
    }
}
