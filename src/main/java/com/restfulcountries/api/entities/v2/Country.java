package com.restfulcountries.api.entities.v2;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class Country {
    @Id
    private UUID id;
    private String name;

    public Country(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public Country() {

    }
}
