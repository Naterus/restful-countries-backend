package com.restfulcountries.api.pojo.v1;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Covid19Pojo(@JsonProperty("total_case") String totalCase,
                          @JsonProperty("total_deaths") String totalDeaths,
                          @JsonProperty("last_updated") String lastUpdated) {}
