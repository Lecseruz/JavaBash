package ru.magomed.exception;

public class DirectoryAlreadyExistException extends RuntimeException{

    public DirectoryAlreadyExistException(){

    }

    public DirectoryAlreadyExistException(String message){
        super(message);
    }
}
