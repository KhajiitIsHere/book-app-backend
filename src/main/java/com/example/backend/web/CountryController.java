package com.example.backend.web;

import com.example.backend.model.Country;
import com.example.backend.services.CountryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/countries")
@AllArgsConstructor
@CrossOrigin(origins = "https://book-app-frontend-196048.herokuapp.com/")
public class CountryController {

    private final CountryService countryService;

    @GetMapping
    List<Country> getAll() {
        return countryService.getAll();
    }
}
