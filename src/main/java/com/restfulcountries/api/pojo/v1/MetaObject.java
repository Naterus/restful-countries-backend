package com.restfulcountries.api.pojo.v1;

import com.fasterxml.jackson.annotation.JsonProperty;

public record MetaObject(@JsonProperty("current_page") Integer currentPage, Integer from,
                         @JsonProperty("last_page") Integer lastPage, String path,
                         @JsonProperty("per_page") Integer perPage, Integer to, Integer total) {}
