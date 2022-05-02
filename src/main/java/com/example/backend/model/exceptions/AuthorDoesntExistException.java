package com.example.backend.model.exceptions;

public class AuthorDoesntExistException extends RuntimeException {
    public AuthorDoesntExistException(Long id){
        super(String.format("Author with id %d doesn't exist", id));
    }
}
