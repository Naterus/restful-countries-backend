package com.restfulcountries.api.integrations.legacy.api;

import com.restfulcountries.api.pojo.v1.CountryPojo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(
        url = "${api.legacy.restfulcountries.url}",
        value = "${api.legacy.restfulcountries.name}"
)
public interface RestfulCountriesClient {
    @GetMapping(path = "/countries", produces = "application/json")
    CountryPojo getCountries(@RequestHeader("Authorization") String token);
}
