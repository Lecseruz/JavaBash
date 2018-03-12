package ru.magomed.exception;

public class NotDirectoryException extends RuntimeException {

    public NotDirectoryException(){

    }

    public NotDirectoryException(String message){
        super(message);
    }
}
