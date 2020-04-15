
package com.ua.airQuality.repositories;

import com.ua.airQuality.models.air.Weather;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
public class WeatherRepositoryTest {
    
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private WeatherRepository weatherRepository;
    
    @Test
    public void whenFindAllByCountryAndStateAndCity_thenReturnListWeather(){
        Weather aveiro = new Weather();
        aveiro.setCity("Aveiro");
        aveiro.setState("Aveiro");
        aveiro.setCountry("Portugal");
        Weather oliveirinha = new Weather();
        oliveirinha.setCity("Oliveirinha");
        oliveirinha.setState("Aveiro");
        oliveirinha.setCountry("Portugal");
        Weather porto = new Weather();
        porto.setCity("Porto");
        porto.setState("Porto");
        porto.setCountry("Portugal");
        
        entityManager.persist(aveiro);
        entityManager.persist(oliveirinha);
        entityManager.persist(porto);
        
        List<Weather> weather = weatherRepository.findAllWeatherByCountryAndStateAndCity("Portugal", "Aveiro","Aveiro");
        
        assertThat(weather).hasSize(1).extracting(Weather::getCity).containsOnly(aveiro.getCity());
        
    }
    
    @Test
    public void whenInvalidCity_thenReturnEmptyList(){
        List<Weather> weather = weatherRepository.findAllWeatherByCountryAndStateAndCity("Portugal", "Aveiro","doesNotExist");
        assertThat(weather).isEmpty();
    }

    @Test
    public void whenInvalidState_thenReturnEmptyList(){
       List<Weather> weather = weatherRepository.findAllWeatherByCountryAndStateAndCity("Portugal", "doesNotExist","Aveiro");
        assertThat(weather).isEmpty();
    }

    @Test
    public void whenInvalidCountry_thenReturnEmptyList(){
       List<Weather> weather = weatherRepository.findAllWeatherByCountryAndStateAndCity("doesNotExist", "Aveiro","Aveiro");
        assertThat(weather).isEmpty();
    }
    
    @Test
    public void whenFindAll_thenReturnListAllWeather(){
        Weather aveiro = new Weather();
        aveiro.setCity("Aveiro");
        aveiro.setState("Aveiro");
        aveiro.setCountry("Portugal");
        Weather oliveirinha = new Weather();
        oliveirinha.setCity("Oliveirinha");
        oliveirinha.setState("Aveiro");
        oliveirinha.setCountry("Portugal");
        Weather porto = new Weather();
        porto.setCity("Porto");
        porto.setState("Porto");
        porto.setCountry("Portugal");
        entityManager.persist(aveiro);
        entityManager.persist(oliveirinha);
        entityManager.persist(porto);
        
        List<Weather> weather = weatherRepository.findAll();
        
        assertThat(weather).hasSize(3).extracting(Weather::getCity).containsOnly(aveiro.getCity(),oliveirinha.getCity(),porto.getCity());
        
    }
    
    
}