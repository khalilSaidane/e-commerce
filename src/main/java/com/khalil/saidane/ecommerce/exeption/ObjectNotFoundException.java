package com.khalil.saidane.ecommerce.exeption;

public class ObjectNotFoundException extends Exception {

    public ObjectNotFoundException(Long id) {
        super(String.format("Object is not found with id : '%s'", id));

    }

}
