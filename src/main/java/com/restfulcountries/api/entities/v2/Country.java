package com.restfulcountries.api.entities.v2;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.Date;
import java.util.UUID;

@Entity
public class Country {
    @Id
    private UUID id;
    private String name;
    @JsonProperty("full_name")
    private String fullName;
    private String description;
    private String capital;
    private Integer population;
    @JsonProperty("independence_date")
    private Date independenceDate;
    private Integer area;
    private String areaMeasureUnit;
    private String currency;
    private String iso2;
    private String iso3;
    private String flag;


    @ManyToOne
    @JoinColumn(
            name = "continent_id",
            nullable = true,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "country_continent_fk"
            )
    )
    @JsonBackReference
    private Continent continent;

    public void setContinent(Continent continent) {
        this.continent = continent;
    }

    public Country(UUID id, String name, String fullName, String description, String capital, Integer population, Date independenceDate, Integer area, String areaMeasureUnit, String currency, String iso2, String iso3, String flag) {
        this.id = id;
        this.name = name;
        this.fullName = fullName;
        this.description = description;
        this.capital = capital;
        this.population = population;
        this.independenceDate = independenceDate;
        this.area = area;
        this.areaMeasureUnit = areaMeasureUnit;
        this.currency = currency;
        this.iso2 = iso2;
        this.iso3 = iso3;
        this.flag = flag;
    }

    public Country() {

    }

    public UUID getId() {
        return id;
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

    public String getCapital() {
        return capital;
    }

    public Integer getPopulation() {
        return population;
    }

    public Date getIndependenceDate() {
        return independenceDate;
    }

    public Integer getArea() {
        return area;
    }

    public String getAreaMeasureUnit() {
        return areaMeasureUnit;
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

    public Continent getContinent() {
        return continent;
    }

    public String getFlag() {
        return flag;
    }
}
