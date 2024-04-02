package com.restfulcountries.api.controllers.v1;

import com.restfulcountries.api.pojo.v1.CountryPojo;
import com.restfulcountries.api.services.v1.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/countries")
public class CountryController {
    private final CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping
    CountryPojo getCountries(){
        return countryService.getCountries();
    }
}
