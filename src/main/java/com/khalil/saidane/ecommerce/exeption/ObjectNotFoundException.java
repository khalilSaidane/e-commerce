package com.khalil.saidane.ecommerce.exeption;

public class ObjectNotFoundException extends Exception {

    public ObjectNotFoundException(String className, Long id) {
        super(String.format(className + " is not found with id : '%s'", id));

    }

}
