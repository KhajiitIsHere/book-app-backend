package com.example.backend.services;

import com.example.backend.model.Author;

import java.util.List;

public interface AuthorService {
    List<Author> getAll();

    Author getById(Long authorId);

    void addAuthor(String name, String surname, Long countryId);

    void deleteAuthor(Long authorId);

    void editAuthor(Long authorId, String name, String surname, Long countryId);
}
