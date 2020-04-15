package com.ua.airQuality.services;

import com.ua.airQuality.models.air.Weather;
import com.ua.airQuality.repositories.WeatherRepository;
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
public class WeatherServiceTest {
    
    @Mock( lenient = true)
    private WeatherRepository repository;

    @InjectMocks
    private WeatherService service;
    
    @BeforeEach
    public void setUp() {
        Weather tokyo = new Weather("2020-04-14T21:00:00.000Z", "24", "1012", "64", "3.06", "189", "10n");
        tokyo.setCountry("Japan");
        tokyo.setState("Tokyo");
        tokyo.setCity("Tokyo");
        Weather aveiro = new Weather("2020-04-14T23:00:00.000Z", "15", "1006", "82", "2.49", "118", "10n");
        aveiro.setCountry("Portugal");
        aveiro.setState("Aveiro");
        aveiro.setCity("Aveiro");

        List<Weather> aveiroList = Arrays.asList(aveiro);
        List<Weather> allPollution = Arrays.asList(aveiro,tokyo);
        Mockito.when(repository.findAll()).thenReturn(allPollution);
        Mockito.when(repository.findAllWeatherByCountryAndStateAndCity(aveiro.getCountry(),aveiro.getState(),aveiro.getCity())).thenReturn(aveiroList);

    }
    
    @Test
     public void getAllWeather_returnAllPollution() {
       Weather tokyo = new Weather("2020-04-14T21:00:00.000Z", "24", "1012", "64", "3.06", "189", "10n");
        tokyo.setCountry("Japan");
        tokyo.setState("Tokyo");
        tokyo.setCity("Tokyo");
        Weather aveiro = new Weather("2020-04-14T23:00:00.000Z", "15", "1006", "82", "2.49", "118", "10n");
        aveiro.setCountry("Portugal");
        aveiro.setState("Aveiro");
        aveiro.setCity("Aveiro");
        
        List<Weather> allWeather = service.getAllWeather();
        
        verifyFindAllWeatherIsCalledOnce();
        assertThat(allWeather).hasSize(2).extracting(Weather::getCity).contains(aveiro.getCity(),tokyo.getCity());
    }
   
    private void verifyFindAllWeatherIsCalledOnce() {
        Mockito.verify(repository, VerificationModeFactory.times(1)).findAll();
        Mockito.reset(repository);
    }
    
    
   /* @Test
    public void whenValidCountry_thenWeatherShouldBeFound() {
        Weather tokyo = new Weather("2020-04-14T21:00:00.000Z", "24", "1012", "64", "3.06", "189", "10n");
        tokyo.setCountry("Japan");
        tokyo.setState("Tokyo");
        tokyo.setCity("Tokyo");
        
        List<Weather> pollution = service.getWeatherByCountryAndStateAndCity(tokyo.getCountry(), tokyo.getState(), tokyo.getCity());
        assertThat(pollution).hasSize(1).extracting(Weather::getCity).contains(tokyo.getCity());
    }

    @Test
    public void whenInValidCountry_thenCountriesShouldBeEmpty() {
        List<Weather> cities = service.getWeatherByCountryAndStateAndCity("Korea", "Aveiro", "Aveiro");
        assertThat(cities).isEmpty();

        verifyFindByCountryIsCalledOnce("Korea", "Aveiro", "Aveiro");
    }
    
    private void verifyFindByCountryIsCalledOnce(String country, String state, String city) {
        Mockito.verify(repository, VerificationModeFactory.times(1)).findAllWeatherByCountryAndStateAndCity(country, state, city);
        Mockito.reset(repository);
    }
*/
}
