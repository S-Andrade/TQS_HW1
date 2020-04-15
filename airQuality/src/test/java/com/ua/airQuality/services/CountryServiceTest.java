/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ua.airQuality.services;

import com.ua.airQuality.models.location.Country;
import com.ua.airQuality.repositories.CountryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.verification.VerificationModeFactory;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class CountryServiceTest {
    
    @Mock( lenient = true)
    private CountryRepository repository;

    @InjectMocks
    private CountryService service;
    
    @BeforeEach
    public void setUp() {
        Country portugal = new Country("Portugal");
        Country japan = new Country("Japan");
        Country korea = new Country("Korea");
        List<Country> allCountries = Arrays.asList(portugal, japan, korea);
        Mockito.when(repository.findAll()).thenReturn(allCountries);
    }
    
    @Test
     public void getAllContries_returnAllCountries() {
        Country portugal = new Country("Portugal");
        Country japan = new Country("Japan");
        Country korea = new Country("Korea");
        
        List<Country> allCountries = service.getAllCountries();
        
        verifyFindAllCountryIsCalledOnce();
        assertThat(allCountries).hasSize(3).extracting(Country::getCountry).contains(portugal.getCountry(),japan.getCountry(),korea.getCountry());
    }
   
    private void verifyFindAllCountryIsCalledOnce() {
        Mockito.verify(repository, VerificationModeFactory.times(1)).findAll();
        Mockito.reset(repository);
    }
}
