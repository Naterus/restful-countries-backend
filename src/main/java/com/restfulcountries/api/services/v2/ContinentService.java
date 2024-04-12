package com.restfulcountries.api.services.v2;

import com.restfulcountries.api.entities.v2.Continent;
import com.restfulcountries.api.entities.v2.Country;
import com.restfulcountries.api.exceptions.NotFoundException;
import com.restfulcountries.api.repositories.ContinentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
public class ContinentService {
    private final ContinentRepository continentRepository;

    public ContinentService(ContinentRepository continentRepository) {
        this.continentRepository = continentRepository;
    }

    public List<Continent> getContinents(){
        return continentRepository.findAll();
    }

    public Continent getContinent(UUID id) {
        return continentRepository.findById(id).orElseThrow(() -> {
            NotFoundException notFoundException = new NotFoundException("Continent not found");
            log.error("Continent with id {} not found",id,notFoundException);
            return notFoundException;
        });
    }

    public List<Country> getCountriesInContinent(UUID id) {
        return continentRepository.findById(id).orElseThrow(() -> {
            NotFoundException notFoundException = new NotFoundException("Continent not found");
            log.error("Continent with id {} not found",id,notFoundException);
            return notFoundException;
        }).getCountries();
    }

}
