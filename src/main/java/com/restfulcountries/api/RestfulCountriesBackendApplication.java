package com.restfulcountries.api;

import com.github.javafaker.Faker;
import com.restfulcountries.api.entities.v2.Continent;
import com.restfulcountries.api.entities.v2.Country;
import com.restfulcountries.api.repositories.ContinentRepository;
import com.restfulcountries.api.repositories.CountryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.Locale;
import java.util.UUID;

@SpringBootApplication
@EnableFeignClients
public class RestfulCountriesBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestfulCountriesBackendApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(CountryRepository countryRepository,
                                        ContinentRepository continentRepository){

        return args -> {

            Faker faker = new Faker(Locale.ENGLISH);

            Country country = new Country(
                    UUID.randomUUID(),
                    faker.country().name(),
                    faker.country().name(),
                    faker.shakespeare().hamletQuote(),
                    faker.country().capital(),
                    faker.number().randomDigit(),
                    new Date(),
                    faker.number().randomDigit(),
                    "Km²",
                    faker.country().currency(),
                    faker.country().countryCode2(),
                    faker.country().countryCode3(),
                    faker.country().flag()
            );

            Continent continent = new Continent(
                    UUID.randomUUID(),
                    faker.name().fullName(),
                    faker.random().nextLong(),
                    "Km²",
                    faker.random().nextLong()
            );

            continentRepository.save(continent);
            country.setContinent(continent);
            countryRepository.save(country);
        };
    }

}
