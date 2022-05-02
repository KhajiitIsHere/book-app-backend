package com.example.backend.services.implementation;

import com.example.backend.model.Country;
import com.example.backend.model.exceptions.CountryDoesntExistException;
import com.example.backend.repository.CountryRepository;
import com.example.backend.services.CountryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    @Override
    public List<Country> getAll() {
        return countryRepository.findAll();
    }

    @Override
    public Country getById(Long countryId) {
        return countryRepository.findById(countryId).orElseThrow(() -> new CountryDoesntExistException(countryId));
    }

    @Override
    public void addCountry(String name, String continent) {
        countryRepository.save(new Country(name, continent));
    }

    @Override
    public void deleteCountry(Long countryId) {
        countryRepository.deleteById(countryId);
    }

    @Override
    public void editCountry(Long countryId, String name, String continent) {
        Country country = countryRepository.getById(countryId);

        country.setName(name);
        country.setContinent(continent);

        countryRepository.save(country);
    }
}
