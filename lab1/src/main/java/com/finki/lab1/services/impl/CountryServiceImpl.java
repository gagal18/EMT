package com.finki.lab1.services.impl;

import com.finki.lab1.model.Country;
import com.finki.lab1.repository.CountryRepository;
import com.finki.lab1.services.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Country> findAll() {
        return this.countryRepository.findAll();
    }

    @Override
    public Country save(Country country) {
        return countryRepository.save(country);
    }

    @Override
    public Optional<Country> findById(Long id) {
        return countryRepository.findById(id);
    }

    @Override
    public Optional<Country> update(Long id, Country country) {
        Optional<Country> existingCountry = countryRepository.findById(id);

        if (existingCountry.isPresent()) {
            Country updatedCountry = existingCountry.get();

            updatedCountry.setName(country.getName());
            updatedCountry.setContinent(country.getContinent());
            countryRepository.save(updatedCountry);

            return Optional.of(updatedCountry);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public void deleteById(Long id) {
        if (countryRepository.existsById(id)) {
            countryRepository.deleteById(id);
        }
    }
}
