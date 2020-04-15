package com.ua.airQuality.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.ua.airQuality.models.air.Pollution;
import java.util.List;

@Repository
@Transactional
public interface PollutionRepository extends JpaRepository<Pollution, Long> {

    List<Pollution> findAll();
    List<Pollution> findAllPollutionByCountryAndStateAndCity(String country, String state, String city);
}
