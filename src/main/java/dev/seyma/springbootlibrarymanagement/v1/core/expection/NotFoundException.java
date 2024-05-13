package dev.seyma.springbootlibrarymanagement.v1.core.expection;

public class NotFoundException extends RuntimeException{
    public NotFoundException(String message) {
        super(message);
    }
}