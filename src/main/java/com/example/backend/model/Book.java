package com.example.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Category category;

    private int availableCopies;

    @ManyToOne
    private Author author;

    public Book(String name, Category category, int availableCopies, Author author) {
        this.name = name;
        this.category = category;
        this.availableCopies = availableCopies;
        this.author = author;
    }

    public Book() {

    }
}
