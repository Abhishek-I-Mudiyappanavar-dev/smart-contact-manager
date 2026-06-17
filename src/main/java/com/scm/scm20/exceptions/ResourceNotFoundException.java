package com.scm.scm20.exceptions;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message){
        super("Resource not found");
    }

}
