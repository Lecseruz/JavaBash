package ru.magomed.exception;

public class DoNotDirectoryException extends RuntimeException {

    public DoNotDirectoryException(){

    }

    public DoNotDirectoryException(String message){
        super(message);
    }
}
