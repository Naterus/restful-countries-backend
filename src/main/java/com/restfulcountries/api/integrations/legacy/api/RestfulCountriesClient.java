package com.restfulcountries.api.integrations.legacy.api;

import com.restfulcountries.api.pojo.v1.CountryObject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
        url = "${api.legacy.restfulcountries.url}",
        value = "${api.legacy.restfulcountries.name}"
)
public interface RestfulCountriesClient {
    @GetMapping(path = "/countries", produces = "application/json")
    CountryObject getCountries(@RequestHeader("Authorization") String token,
                               @RequestParam Integer per_page,
                               @RequestParam String continent,
                               @RequestParam Integer population_from,
                               @RequestParam Integer population_to,
                               @RequestParam Integer size_from,
                               @RequestParam Integer size_to,
                               @RequestParam String iso2,
                               @RequestParam String iso3,
                               @RequestParam Integer code,
                               @RequestParam String fetch_type
    );
}
