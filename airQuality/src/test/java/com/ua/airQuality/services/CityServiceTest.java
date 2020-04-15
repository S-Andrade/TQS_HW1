/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ua.airQuality.services;

import com.ua.airQuality.models.location.City;
import com.ua.airQuality.repositories.CityRepository;
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
public class CityServiceTest {
    
    @Mock( lenient = true)
    private CityRepository repository;

    @InjectMocks
    private CityService service;
    
    @BeforeEach
    public void setUp() {
        City aveiro = new City("Aveiro","Aveiro","Portugal");
        City porto = new City("Porto","Porto","Portugal");
        City tokyo = new City("Tokyo","Tokyo","Japan");
        List<City> allCities = Arrays.asList(aveiro,porto,tokyo);
        Mockito.when(repository.findAll()).thenReturn(allCities);
    }
    
    @Test
     public void getAllCities_returnAllCities() {
        City aveiro = new City("Aveiro","Aveiro","Portugal");
        City porto = new City("Porto","Porto","Portugal");
        City tokyo = new City("Tokyo","Tokyo","Japan");
        
        List<City> allCities = service.getAllCities();
        
        verifyFindAllCityIsCalledOnce();
        assertThat(allCities).hasSize(3).extracting(City::getCity).contains(aveiro.getCity(),porto.getCity(),tokyo.getCity());
    }
   
    private void verifyFindAllCityIsCalledOnce() {
        Mockito.verify(repository, VerificationModeFactory.times(1)).findAll();
        Mockito.reset(repository);
    }
    
    
    /*@Test
    public void whenValidCountry_thenStateShouldBeFound() {
        City tokyo = new City("Tokyo","Tokyo","Japan");
        List<City> cities = service.getCitiesByCountryAndState("Japan", "Tokyo");
        assertThat(cities).hasSize(1).extracting(City::getCity).contains(tokyo.getCity());
    }

    @Test
    public void whenInValidCountry_thenCountriesShouldBeEmpty() {
        List<City> cities = service.getCitiesByCountryAndState("Korea", "Aveiro");
        assertThat(cities).isEmpty();

        verifyFindByCountryIsCalledOnce("Korea","Aveiro");
    }
    
    private void verifyFindByCountryIsCalledOnce(String country, String state) {
        Mockito.verify(repository, VerificationModeFactory.times(1)).findAllByCountryAndState(country, state);
        Mockito.reset(repository);
    }
    */
}
