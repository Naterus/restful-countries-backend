package com.restfulcountries.api.pojo.v1;

import com.restfulcountries.api.entities.v1.Country;
import java.util.List;

public record CountryObject(List<Country> data,
                            LinksObject links,
                            MetaObject meta) {}
