package com.example.backend.services.implementation;

import com.example.backend.model.Author;
import com.example.backend.model.Country;
import com.example.backend.model.exceptions.AuthorDoesntExistException;
import com.example.backend.repository.AuthorRepository;
import com.example.backend.services.AuthorService;
import com.example.backend.services.CountryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final CountryService countryService;

    @Override
    public List<Author> getAll() {
        return authorRepository.findAll();
    }

    @Override
    public Author getById(Long authorId) {
        return authorRepository.findById(authorId).orElseThrow(() -> new AuthorDoesntExistException(authorId));
    }

    @Override
    public void addAuthor(String name, String surname, Long countryId) {
        Country country = countryService.getById(countryId);

        authorRepository.save(new Author(name, surname, country));
    }

    @Override
    public void deleteAuthor(Long authorId) {
        authorRepository.deleteById(authorId);
    }

    @Override
    public void editAuthor(Long authorId, String name, String surname, Long countryId) {
        Author author = authorRepository.findById(authorId).orElseThrow(() -> new AuthorDoesntExistException(authorId));
        Country country = countryService.getById(countryId);

        author.setName(name);
        author.setSurname(surname);
        author.setCountry(country);

        authorRepository.save(author);
    }
}
