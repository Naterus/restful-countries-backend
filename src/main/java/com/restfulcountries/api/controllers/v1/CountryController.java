package com.restfulcountries.api.controllers.v1;

import com.restfulcountries.api.pojo.v1.CountryPojo;
import com.restfulcountries.api.services.v1.CountryService;
import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    CountryPojo getCountries(@RequestParam @Nullable Integer per_page,
                             @RequestParam @Nullable String continent,
                             @RequestParam @Nullable Integer population_from,
                             @RequestParam @Nullable Integer population_to,
                             @RequestParam @Nullable Integer size_from,
                             @RequestParam @Nullable Integer size_to,
                             @RequestParam @Nullable String iso2,
                             @RequestParam @Nullable String iso3,
                             @RequestParam @Nullable Integer code,
                             @RequestParam @Nullable String fetch_type
                             ){
        return countryService.getCountries(per_page,continent,population_from,population_to,size_from,size_to,iso2,iso3,code,fetch_type);
    }
}
