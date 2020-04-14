package com.ua.airQuality.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.ua.airQuality.models.location.Country;

import java.util.List;

@Repository
@Transactional
public interface CountryRepository extends JpaRepository<Country, Long> {

    List<Country> findAll();
    
}
