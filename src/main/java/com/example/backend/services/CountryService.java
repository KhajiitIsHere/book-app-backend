package com.example.backend.services;

import com.example.backend.model.Author;
import com.example.backend.model.Country;

import java.util.List;

public interface CountryService {
    List<Country> getAll();

    Country getById(Long countryId);

    void addCountry(String name, String continent);

    void deleteCountry(Long countryId);

    void editCountry(Long countryId, String name, String continent);
}
