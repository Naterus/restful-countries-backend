package com.restfulcountries.api.services.v2;

import com.restfulcountries.api.entities.v2.Continent;
import com.restfulcountries.api.exceptions.NotFoundException;
import com.restfulcountries.api.repositories.ContinentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.internal.matchers.Not;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.BDDMockito.*;

@ExtendWith(MockitoExtension.class)
class ContinentServiceTest {
    @Mock
    private ContinentRepository continentRepository;

    @InjectMocks
    private ContinentService continentService;

    @Test
    void itShouldGetListOfContinentsSuccessfully() {
        //Given
        Continent continent =  new Continent(UUID.randomUUID(),"Europe",20000L,"km2",300000L);
        Continent continent2 =  new Continent(UUID.randomUUID(),"Africa",80000L,"km2",900000L);
        given(continentRepository.findAll()).willReturn(List.of(continent,continent2));

        //When
        var continents = continentService.getContinents();

        //Then
        assertThat(continents).isNotNull();
        assertThat(continents.size()).isEqualTo(2);
    }

    @Test
    void itShouldGetContinentByIdSuccessfully() {
        //Given
        Continent continent =  new Continent(UUID.randomUUID(),"Europe",20000L,"km2",300000L);
        given(continentRepository.findById(continent.getId())).willReturn(Optional.of(continent));

        //When
        var getContinent = continentService.getContinent(continent.getId());

        //Then
        assertThat(getContinent).isNotNull();
    }

    @Test
    void itShouldThrowExceptionIfContinentNotFound() {
        //Given
        UUID continentId = UUID.randomUUID();
        given(continentRepository.findById(continentId)).willReturn(Optional.empty());

        //When
        //Then
        assertThatThrownBy(() ->{
            continentService.getContinent(continentId);
        }).isInstanceOf(NotFoundException.class).hasMessageContaining("Continent not found");
    }

    @Test
    void itShouldGetCountriesInContinentSuccessfully() {
        //Given
        Continent continent =  new Continent(UUID.randomUUID(),"Europe",20000L,"km2",300000L);
        given(continentRepository.findById(continent.getId())).willReturn(Optional.of(continent));

        //When
        var getContinent = continentService.getCountriesInContinent(continent.getId());

        //Then
        assertThat(getContinent).isNotNull();
    }

    @Test
    void itShouldThrowExceptionIfContinentNotFoundForCountries() {
        //Given
        UUID continentId = UUID.randomUUID();
        given(continentRepository.findById(continentId)).willReturn(Optional.empty());

        //When
        //Then
        assertThatThrownBy(() -> {
            continentService.getCountriesInContinent(continentId);
        }).isInstanceOf(NotFoundException.class).hasMessageContaining("Continent not found");
    }
}