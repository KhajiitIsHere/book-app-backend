package com.example.backend.initializer;

import com.example.backend.model.Country;
import com.example.backend.services.AuthorService;
import com.example.backend.services.CountryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@AllArgsConstructor
public class DataInitializer {

    private final AuthorService authorService;
    private final CountryService countryService;

    @PostConstruct
    void fillDatabaseWithAuthorsAndCountries() {
        System.out.println("STARTED");
        countryService.addCountry("Name", "Europe");
        countryService.addCountry("England", "Europe");
        countryService.addCountry("Mexico", "South America");
        countryService.addCountry("SAD", "North America");

        authorService.addAuthor("Author 1", "Author 1", 1L);
        authorService.addAuthor("Author 2", "Author 2", 2L);
        authorService.addAuthor("Author 3", "Author 3", 3L);
        authorService.addAuthor("Author 4", "Author 4", 4L);
    }
}
