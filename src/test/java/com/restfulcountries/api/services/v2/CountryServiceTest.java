package com.restfulcountries.api.services.v2;

import com.github.javafaker.Faker;
import com.restfulcountries.api.entities.v2.Country;
import com.restfulcountries.api.exceptions.NotFoundException;
import com.restfulcountries.api.repositories.CountryRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class CountryServiceTest {
    @Mock
    private CountryRepository countryRepository;

    @InjectMocks
    private CountryService countryService;

    @Test
    void itShouldReturnListOfCountriesSuccessfully() {
        //Given
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

        Country country2 = new Country(
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
        given(countryRepository.findAll()).willReturn(List.of(country,country2));

        //When
        List<Country> countries = countryService.getCountries();

        //Then
        assertThat(countries).isNotNull();
        assertThat(countries.size()).isEqualTo(2);
    }

    @Test
    void itShouldGetCountryByIdSuccessfully() {
        //Given
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
        given(countryRepository.findById(country.getId())).willReturn(Optional.of(country));

        //When
        Country getCountry = countryService.getCountry(country.getId());

        //Then
        assertThat(getCountry).isNotNull();
    }

    @Test
    void itShouldReturnNullIfCountryNotFound() {
        //Given
        UUID countryId = UUID.randomUUID();
        given(countryRepository.findById(countryId)).willReturn(Optional.empty());

        //When
        //Then
        assertThatThrownBy(() -> {
            countryService.getCountry(countryId);
        }).isInstanceOf(NotFoundException.class).hasMessageContaining("Country not found");
    }
}