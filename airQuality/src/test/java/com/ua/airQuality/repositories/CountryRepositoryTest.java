package com.ua.airQuality.repositories;

import com.ua.airQuality.models.location.Country;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class CountryRepositoryTest {
    
    @Autowired
    private CountryRepository countryRepository;
    
        
    @Test
    public void whenFindAll_thenReturnListAllCountries(){
        //Por causa do bean que consome os Paises tem de ter sempre 95 paises        
        List<Country> countries = countryRepository.findAll();
        
        assertThat(countries).hasSize(95);
        
    }
    
    
}
