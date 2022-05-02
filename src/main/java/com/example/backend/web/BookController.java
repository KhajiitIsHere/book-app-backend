package com.example.backend.web;

import com.example.backend.model.Book;
import com.example.backend.model.Category;
import com.example.backend.model.dto.BookDto;
import com.example.backend.services.BookService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/books")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class BookController {

    private final BookService bookService;

    @GetMapping
    List<Book> getAll() {
        return bookService.getAll();
    }

    @GetMapping("/categories")
    List<Category> getAllCategories(){
        return Arrays.asList(Category.values());
    }

    @PostMapping
    void addBook(@RequestBody BookDto bookDto) {
        bookService.addBook(bookDto.getName(), bookDto.getCategory(), bookDto.getAuthorId(), bookDto.getAvailableCopies());
    }

    @PostMapping("/edit/{id}")
    void editBook(@PathVariable Long id, @RequestBody BookDto bookDto) {
        bookService.editBook(id, bookDto.getName(), bookDto.getCategory(), bookDto.getAuthorId(), bookDto.getAvailableCopies());
    }

    @PostMapping("/delete/{id}")
    void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }

    @PostMapping("/mark-taken/{id}")
    void markBookAsTaken(@PathVariable Long id) {
        bookService.markAsTaken(id);
    }

}
