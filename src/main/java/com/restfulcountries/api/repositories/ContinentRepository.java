package com.restfulcountries.api.repositories;

import com.restfulcountries.api.entities.v2.Continent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ContinentRepository extends JpaRepository <Continent,UUID> {
}
