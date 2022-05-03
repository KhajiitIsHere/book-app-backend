package com.example.backend.web;

import com.example.backend.model.Author;
import com.example.backend.services.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/authors")
@CrossOrigin(origins = "https://book-app-frontend-196048.herokuapp.com/")
public class AuthorController {

    private final AuthorService authorService;

    @GetMapping
    List<Author> getAll(){
        return authorService.getAll();
    }
}
