package com.restfulcountries.api.services.v2;

import com.restfulcountries.api.entities.v2.Continent;
import com.restfulcountries.api.entities.v2.Country;
import com.restfulcountries.api.repositories.ContinentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
public class ContinentService {
    private final ContinentRepository continentRepository;

    public ContinentService(ContinentRepository continentRepository) {
        this.continentRepository = continentRepository;
    }

    public List<Continent> getContinents(){
        return continentRepository.findAll();
    }

    public Optional<Continent> getContinent(UUID id) {
        return continentRepository.findById(id);
    }

    public List<Country> getCountriesInContinent(UUID id) {
        return Objects.requireNonNull(continentRepository.findById(id).orElse(new Continent())).getCountries();
    }

}
