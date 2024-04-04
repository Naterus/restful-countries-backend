package com.restfulcountries.api.controllers.v2;

import com.restfulcountries.api.entities.v2.Continent;
import com.restfulcountries.api.services.v2.ContinentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("api/v2/continents")
public class ContinentController {
    private final ContinentService continentService;

    public ContinentController(ContinentService continentService) {
        this.continentService = continentService;
    }

    @GetMapping
    List<Continent> getContinents(){
        return continentService.getContinents();
    }

    @GetMapping(path = "/{id}")
    Optional<Continent> getContinent(@PathVariable UUID id){
        return continentService.getContinent(id);
    }
}
