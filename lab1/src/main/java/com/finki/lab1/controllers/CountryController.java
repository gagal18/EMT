package com.finki.lab1.controllers;

import com.finki.lab1.model.Country;
import com.finki.lab1.services.CountryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/countries")
public class CountryController {

    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }
    @GetMapping
    public List<Country> getAllCountries() {
        return this.countryService.findAll();
    }

    @PostMapping
    public Country create(@RequestBody Country country) {
        return this.countryService.save(country);
    }

    @GetMapping("/{id}")
    public Country getCountryById(@PathVariable Long id) {
        Optional<Country> country = this.countryService.findById(id);
        return country.orElse(null);
    }

    @PutMapping("/{id}")
    public Country updateCountry(@PathVariable Long id, @RequestBody Country country) {
        Optional<Country> updatedCountry = this.countryService.update(id, country);
        return updatedCountry.orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deleteCountry(@PathVariable Long id) {
        this.countryService.deleteById(id);
    }
}
