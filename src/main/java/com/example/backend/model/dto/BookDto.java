package com.example.backend.model.dto;

import com.example.backend.model.Author;
import com.example.backend.model.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@AllArgsConstructor
@Getter
public class BookDto {

    private final String name;

    private final Category category;

    private final int availableCopies;

    private final Long authorId;


}
