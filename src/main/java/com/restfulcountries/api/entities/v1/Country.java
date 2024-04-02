package com.restfulcountries.api.entities.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.restfulcountries.api.pojo.v1.Covid19Pojo;
import com.restfulcountries.api.pojo.v1.HrefPojo;

public record Country(String name, @JsonProperty("full_name") String fullName, String description, String continent,
                      String capital, String population, @JsonProperty("independence_date") String independenceDate,
                      String size, String currency, String iso2, String iso3, Covid19Pojo covid19, HrefPojo href) {}
