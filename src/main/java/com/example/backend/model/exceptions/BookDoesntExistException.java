package com.example.backend.model.exceptions;

public class BookDoesntExistException extends RuntimeException{
    public BookDoesntExistException(Long id){
        super(String.format("Book with id %d doesn't exist", id));
    }
}
