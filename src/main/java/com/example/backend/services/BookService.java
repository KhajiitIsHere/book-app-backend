package com.example.backend.services;

import com.example.backend.model.Book;
import com.example.backend.model.Category;

import java.util.List;

public interface BookService {

    List<Book> getAll();

    void addBook(String name, Category category, Long authorId, int availableCopies);

    void deleteBook(Long bookId);

    void editBook(Long bookId, String name, Category category, Long authorId, int availableCopies);

    void markAsTaken(Long bookId);
}
