package com.restfulcountries.api.entities.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.restfulcountries.api.pojo.v1.Covid19Object;
import com.restfulcountries.api.pojo.v1.HrefObject;

public record Country(String name, @JsonProperty("full_name") String fullName, String description, String continent,
                      String capital, String population, @JsonProperty("independence_date") String independenceDate,
                      String size, String currency, String iso2, String iso3, Covid19Object covid19, HrefObject href) {}
