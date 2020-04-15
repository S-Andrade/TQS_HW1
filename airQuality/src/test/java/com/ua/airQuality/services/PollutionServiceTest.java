package com.ua.airQuality.services;

import com.ua.airQuality.models.air.Pollution;
import com.ua.airQuality.repositories.PollutionRepository;
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
import org.springframework.beans.factory.annotation.Autowired;

@ExtendWith(MockitoExtension.class)
public class PollutionServiceTest {
    
    @Mock( lenient = true)
    private PollutionRepository repository;

    @Autowired
    @InjectMocks
    private PollutionService service;
    
    @BeforeEach
    public void setUp() {
        Pollution tokyo = new Pollution("2020-04-14T21:00:00.000Z","53","p2","19","p2");
        tokyo.setCountry("Japan");
        tokyo.setState("Tokyo");
        Pollution aveiro = new Pollution("2020-04-14T14:00:00.000Z","1","n2","4","n2");
        tokyo.setCity("Tokyo");
        aveiro.setCountry("Portugal");
        aveiro.setState("Aveiro");
        aveiro.setCity("Aveiro");

        List<Pollution> aveiroList = Arrays.asList(aveiro);
        List<Pollution> allPollution = Arrays.asList(aveiro,tokyo);
        Mockito.when(repository.findAll()).thenReturn(allPollution);
        Mockito.when(repository.findAllPollutionByCountryAndStateAndCity(aveiro.getCountry(),aveiro.getState(),aveiro.getCity())).thenReturn(aveiroList);

    }
    
    @Test
     public void getAllPollution_returnAllPollution() {
       Pollution tokyo = new Pollution("2020-04-14T21:00:00.000Z","53","p2","19","p2");
        tokyo.setCountry("Japan");
        tokyo.setState("Tokyo");
        tokyo.setCity("Tokyo");
        Pollution aveiro = new Pollution("2020-04-14T14:00:00.000Z","1","n2","4","n2");
        aveiro.setCountry("Portugal");
        aveiro.setState("Aveiro");
        aveiro.setCity("Aveiro");
        
        List<Pollution> allPollution = service.getAllPollution();
        
        verifyFindAllPollutionIsCalledOnce();
        assertThat(allPollution).hasSize(2).extracting(Pollution::getCity).contains(aveiro.getCity(),tokyo.getCity());
    }
   
    private void verifyFindAllPollutionIsCalledOnce() {
        Mockito.verify(repository, VerificationModeFactory.times(1)).findAll();
        Mockito.reset(repository);
    }
    
    
    /*@Test
    public void whenValidCountry_thenPollutionShouldBeFound() {
        Pollution tokyo = new Pollution("2020-04-14T21:00:00.000Z","53","p2","19","p2");
        tokyo.setCountry("Japan");
        tokyo.setState("Tokyo");
        tokyo.setCity("Tokyo");
        
        List<Pollution> pollution = service.getPollutionByCountryAndStateAndCity(tokyo.getCountry(), tokyo.getState(), tokyo.getCity());
        assertThat(pollution).hasSize(1).extracting(Pollution::getCity).contains(tokyo.getCity());
    }

    @Test
    public void whenInValidCountry_thenCountriesShouldBeEmpty() {
        List<Pollution> cities = service.getPollutionByCountryAndStateAndCity("Korea", "Aveiro", "Aveiro");
        assertThat(cities).isEmpty();

        verifyFindByCountryIsCalledOnce("Korea", "Aveiro", "Aveiro");
    }
    
    private void verifyFindByCountryIsCalledOnce(String country, String state, String city) {
        Mockito.verify(repository, VerificationModeFactory.times(1)).findAllPollutionByCountryAndStateAndCity(country, state, city);
        Mockito.reset(repository);
    }*/

}
