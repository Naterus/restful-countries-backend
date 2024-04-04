package com.restfulcountries.api.entities.v2;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class Continent {
    @Id
    private UUID id;
    private String name;
    private Long area;
    private String areaMeasureUnit;
    private Long population;

    @OneToMany(
            mappedBy = "continent",
            orphanRemoval = true,
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            fetch = FetchType.LAZY
    )
    private final List<Country> countries = new ArrayList<>();

    public Continent(UUID id, String name, Long area, String areaMeasureUnit, Long population) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.areaMeasureUnit = areaMeasureUnit;
        this.population = population;
    }

    public Continent() {

    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getArea() {
        return area;
    }

    public String getAreaMeasureUnit() {
        return areaMeasureUnit;
    }

    public Long getPopulation() {
        return population;
    }
}
