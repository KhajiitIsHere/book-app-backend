package com.example.backend.model.exceptions;

public class CountryDoesntExistException extends RuntimeException{
    public CountryDoesntExistException(Long id){
        super(String.format("Country with id %d doesn't exist", id));
    }
}
