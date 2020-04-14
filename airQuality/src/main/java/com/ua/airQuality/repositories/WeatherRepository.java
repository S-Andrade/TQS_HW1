
package com.ua.airQuality.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.ua.airQuality.models.air.Weather;

import java.util.List;

@Repository
@Transactional
public interface WeatherRepository extends JpaRepository<Weather, Long> {

    List<Weather> findAll();
    List<Weather> findAllWeatherByCountryAndStateAndCity(String country, String state, String city);

    
}
