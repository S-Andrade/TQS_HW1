
package com.ua.airQuality.repositories;

import com.ua.airQuality.models.location.City;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class CityRepositoryTest {
    
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CityRepository cityRepository;
    
    @Test
    public void whenFindAllByCountryAndState_thenReturnListCities(){
        City aveiro = new City("Aveiro","Aveiro","Portugal");
        City oliveirinha = new City("Oliveirinha","Aveiro","Portugal");
        City porto = new City("Porto","Porto","Portugal");
        
        entityManager.persist(aveiro);
        entityManager.persist(oliveirinha);
        entityManager.persist(porto);
        
        List<City> cities = cityRepository.findAllByCountryAndState("Portugal", "Aveiro");
        
        assertThat(cities).hasSize(2).extracting(City::getCity).containsOnly(aveiro.getCity(),oliveirinha.getCity());
        
    }
    
    @Test
    public void whenInvalidState_thenReturnEmptyList(){
        List<City> cities = cityRepository.findAllByCountryAndState("Portugal", "doesNotExist");
        assertThat(cities).isEmpty();
    }

    @Test
    public void whenInvalidCountry_thenReturnEmptyList(){
        List<City> cities = cityRepository.findAllByCountryAndState("doesNotExist", "Aveiro");
        assertThat(cities).isEmpty();
    }
    
    @Test
    public void whenFindAll_thenReturnListAllCities(){
        City aveiro = new City("Aveiro","Aveiro","Portugal");
        City oliveirinha = new City("Oliveirinha","Aveiro","Portugal");
        City porto = new City("Porto","Porto","Portugal");
        
        entityManager.persist(aveiro);
        entityManager.persist(oliveirinha);
        entityManager.persist(porto);
        
        List<City> cities = cityRepository.findAll();
        
        assertThat(cities).hasSize(3).extracting(City::getCity).containsOnly(aveiro.getCity(),oliveirinha.getCity(),porto.getCity());
        
    }
    
    
}
