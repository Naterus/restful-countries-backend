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

    public CountryPojo getCountries(Integer per_page,
                                    String continent,
                                    Integer population_from,
                                    Integer population_to,
                                    Integer size_from,
                                    Integer size_to,
                                    String iso2,
                                    String iso3,
                                    Integer code,
                                    String fetch_type){

        try {
            return restfulCountriesClient.getCountries(STR."Bearer \{token}", per_page, continent, population_from, population_to,
                    size_from, size_to, iso2, iso3, code, fetch_type);
        } catch (Exception e){
            throw new IllegalStateException("Error retrieving data", e);
        }
    }
}
