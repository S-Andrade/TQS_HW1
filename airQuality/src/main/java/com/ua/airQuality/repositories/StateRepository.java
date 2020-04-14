package com.ua.airQuality.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.ua.airQuality.models.location.State;

import java.util.List;

@Repository
@Transactional
public interface StateRepository extends JpaRepository<State, Long> {
     List<State> findAll();
     List<State> findAllByCountry(String Country);
    
}
