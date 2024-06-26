package com.restfulcountries.api.services.v2;

import com.restfulcountries.api.entities.v2.Country;
import com.restfulcountries.api.exceptions.NotFoundException;
import com.restfulcountries.api.repositories.CountryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service("country-service-v2")
@Slf4j
public class CountryService {
    private final CountryRepository countryRepository;

    @Autowired
    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public List<Country> getCountries(){
        return countryRepository.findAll();
    }

    public Country getCountry(UUID id) {
        return countryRepository.findById(id).orElseThrow(() ->{
            NotFoundException notFoundException = new NotFoundException("Country not found");
            log.error("Country with id {} not found",id,notFoundException);
            return notFoundException;
        });
    }
}
