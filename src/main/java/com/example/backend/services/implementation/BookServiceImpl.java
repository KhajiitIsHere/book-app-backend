package com.example.backend.services.implementation;

import com.example.backend.model.Author;
import com.example.backend.model.Book;
import com.example.backend.model.Category;
import com.example.backend.repository.BookRepository;
import com.example.backend.services.AuthorService;
import com.example.backend.services.BookService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorService authorService;

    @Override
    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    @Override
    public void addBook(String name, Category category, Long authorId, int availableCopies) {
        Author author = authorService.getById(authorId);

        bookRepository.save(new Book(name, category, availableCopies, author));
    }

    @Override
    public void deleteBook(Long bookId) {
        bookRepository.deleteById(bookId);
    }

    @Override
    public void editBook(Long bookId, String name, Category category, Long authorId, int availableCopies) {
        Book book = bookRepository.getById(bookId);
        Author author = authorService.getById(authorId);

        book.setName(name);
        book.setCategory(category);
        book.setAuthor(author);
        book.setAvailableCopies(availableCopies);

        bookRepository.save(book);
    }

    @Override
    public void markAsTaken(Long bookId) {
        Book book = bookRepository.getById(bookId);

        book.setAvailableCopies(book.getAvailableCopies() - 1);

        if(book.getAvailableCopies() > 0)
            bookRepository.save(book);
        else
            bookRepository.deleteById(bookId);
    }
}
