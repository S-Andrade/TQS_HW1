
package com.ua.airQuality.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.ua.airQuality.models.location.City;



import java.util.List;

@Repository
@Transactional
public interface CityRepository extends JpaRepository<City, Long> {
    
    List<City> findAll();
    List<City> findAllByCountryAndState(String country, String state);
    
}
