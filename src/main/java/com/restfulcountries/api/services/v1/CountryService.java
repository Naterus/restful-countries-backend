package com.restfulcountries.api.services.v1;

import com.restfulcountries.api.integrations.legacy.api.RestfulCountriesClient;
import com.restfulcountries.api.pojo.v1.CountryPojo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class CountryService {
    private final RestfulCountriesClient restfulCountriesClient;
    @Value("${api.legacy.restfulcountries.token}")
    private String token;

    public CountryService(RestfulCountriesClient restfulCountriesClient) {
        this.restfulCountriesClient = restfulCountriesClient;
    }

    public CountryPojo getCountries(){
        return restfulCountriesClient.getCountries(STR."Bearer \{token}");
    }
}
