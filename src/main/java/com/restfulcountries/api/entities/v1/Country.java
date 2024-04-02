package com.restfulcountries.api.entities.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.restfulcountries.api.pojo.v1.Covid19Pojo;
import com.restfulcountries.api.pojo.v1.HrefPojo;

public class Country {
    private final String name;

    @JsonProperty("full_name")
    private final String fullName;
    private final String description;
    private final String continent;
    private final String capital;
    private final String population;
    @JsonProperty("independence_date")
    private final String independenceDate;

    private final String size;
    private final String currency;
    private final String iso2;
    private final String iso3;

    private final Covid19Pojo covid19;

    private final HrefPojo href;

    public Country(String name, String fullName, String description, String continent, String capital, String population, String independenceDate, String size, String currency, String iso2, String iso3, Covid19Pojo covid19, HrefPojo href) {
        this.name = name;
        this.fullName = fullName;
        this.description = description;
        this.continent = continent;
        this.capital = capital;
        this.population = population;
        this.independenceDate = independenceDate;
        this.size = size;
        this.currency = currency;
        this.iso2 = iso2;
        this.iso3 = iso3;
        this.covid19 = covid19;
        this.href = href;
    }

    public String getName() {
        return name;
    }

    public String getFullName() {
        return fullName;
    }

    public String getDescription() {
        return description;
    }

    public String getContinent() {
        return continent;
    }

    public String getCapital() {
        return capital;
    }

    public String getPopulation() {
        return population;
    }

    public String getIndependenceDate() {
        return independenceDate;
    }

    public String getSize() {
        return size;
    }

    public String getCurrency() {
        return currency;
    }

    public String getIso2() {
        return iso2;
    }

    public String getIso3() {
        return iso3;
    }

    public Covid19Pojo getCovid19() {
        return covid19;
    }

    public HrefPojo getHref() {
        return href;
    }

    @Override
    public String toString() {
        return STR."Country{name='\{name}\{'\''}, fullName='\{fullName}\{'\''}, description='\{description}\{'\''}, continent='\{continent}\{'\''}, capital='\{capital}\{'\''}, population='\{population}\{'\''}, independenceDate='\{independenceDate}\{'\''}, size='\{size}\{'\''}, currency='\{currency}\{'\''}, iso2='\{iso2}\{'\''}, iso3='\{iso3}\{'\''}, covid19=\{covid19}, href=\{href}\{'}'}";
    }
}
