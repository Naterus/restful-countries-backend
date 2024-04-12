package com.restfulcountries.api.controllers.v2;

import com.restfulcountries.api.entities.v2.Country;
import com.restfulcountries.api.services.v2.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController("country-controller-v2")
@RequestMapping("api/v2/countries")
public class CountryController {

    private final CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping
    List<Country> getCountries(){
        return countryService.getCountries();
    }

    @GetMapping (path = "/{id}")
    Country getCountry(@PathVariable UUID id){
        return countryService.getCountry(id);
    }
}
