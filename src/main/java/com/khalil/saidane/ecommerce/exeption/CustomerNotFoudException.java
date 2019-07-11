package com.khalil.saidane.ecommerce.exeption;

public class CustomerNotFoudException extends Exception {
    private Long customerId;

    public CustomerNotFoudException( Long customerId) {
        super(String.format("Customer is not found with id : '%s'", customerId));

    }
}
